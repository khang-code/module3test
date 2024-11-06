package com.example.quanlyphongtro.controller;

import com.example.quanlyphongtro.model.entity.Room;
import com.example.quanlyphongtro.service.RoomService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/rooms"})
public class RoomController extends HttpServlet {

    private RoomService roomService = new RoomService();  // Service to handle business logic
    private List<Room> rooms;  // List to hold rooms
    private RequestDispatcher dispatcher;  // Dispatcher to forward to JSP pages

    // Default constructor, no need to define explicitly
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        // If no action is provided, set it to empty string
        if (action == null) {
            action = "";
        }

        // Switch based on the action parameter
        switch (action) {
            case "search":
                // Search rooms by name
                String searchQuery = request.getParameter("searchByName");
                rooms = roomService.findRoomByName(searchQuery);  // Call service to search by name
                request.setAttribute("rooms", rooms);  // Set rooms as request attribute
                dispatcher = request.getRequestDispatcher("WEB-INF/view/room/roomList.jsp");  // Forward to JSP page
                dispatcher.forward(request, response);
                break;

            default:
                // Default action: Display all rooms
                rooms = roomService.findAllRooms();  // Call service to get all rooms
                request.setAttribute("rooms", rooms);  // Set rooms as request attribute
                dispatcher = request.getRequestDispatcher("WEB-INF/view/room/roomList.jsp");  // Forward to JSP page
                dispatcher.forward(request, response);
                break;
        }
    }
}
