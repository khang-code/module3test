create database phongtro;
use phongtro;
CREATE TABLE room (
    id INT AUTO_INCREMENT PRIMARY KEY, 
    ma_phong VARCHAR(20) NOT NULL, 
    ngay_bat_dau DATE NOT NULL, 
    hinh_thuc_thanh_toan ENUM('Theo tháng', 'Theo quý', 'Theo năm') NOT NULL,
    ghi_chu TEXT,
    nguoi_dung_id INT, 
    FOREIGN KEY (nguoi_dung_id) REFERENCES user(id) ON DELETE CASCADE,
    UNIQUE (ma_phong) 
);
CREATE TABLE User (
    id INT AUTO_INCREMENT PRIMARY KEY, 
    ten_nguoi_dung VARCHAR(100) NOT NULL, 
    so_dien_thoai VARCHAR(15) NOT NULL, 
    email VARCHAR(100), 
    dia_chi VARCHAR(255), 
    UNIQUE (so_dien_thoai),
    CHECK (CHAR_LENGTH(ten_nguoi_dung) BETWEEN 5 AND 50)  -- Kiểm tra tên người thuê từ 5 đến 50 ký tự
);
DELIMITER $$
CREATE TRIGGER validate_User
BEFORE INSERT ON User
FOR EACH ROW
BEGIN
    IF NEW.ten_nguoi_dung REGEXP '[^a-zA-Z\s]' THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Tên người thuê không được chứa ký tự đặc biệt hoặc số!';
    END IF;
    
    IF CHAR_LENGTH(NEW.ten_nguoi_dung) < 5 OR CHAR_LENGTH(NEW.ten_nguoi_dung) > 50 THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Tên người thuê phải có từ 5 đến 50 ký tự!';
    END IF;
END $$

DELIMITER ;
INSERT INTO User (ten_nguoi_dung, so_dien_thoai, email, dia_chi)
VALUES 
('NguyễnVănA', '0901234567', 'nguyen.a@example.com', 'Hà Nội'),
('TrầnThịB', '0912345678', 'tran.b@example.com', 'TP. HCM'),
('LêMinhC', '0923456789', 'le.c@example.com', 'Đà Nẵng'),
('PhạmQuangD', '0934567890', 'pham.d@example.com', 'Cần Thơ'),
('HoàngAnhE', '0945678901', 'hoang.e@example.com', 'Hải Phòng');
INSERT INTO room (ma_phong, ngay_bat_dau, hinh_thuc_thanh_toan, ghi_chu, nguoi_dung_id)
VALUES
('P001', '2024-01-01', 'Theo tháng', 'Đặt cọc 1 tháng', 1),
('P002', '2024-02-01', 'Theo quý', 'Thanh toán trước 3 tháng', 2), 
('P003', '2024-03-01', 'Theo năm', 'Không có ghi chú', 3),
('P004', '2024-04-01', 'Theo tháng', 'Thanh toán qua chuyển khoản', 4),
('P005', '2024-05-01', 'Theo quý', 'Đặt cọc 2 tháng', 5);