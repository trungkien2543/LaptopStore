USE [master]
GO
/****** Object:  Database [QLCuaHangLaptop]    Script Date: 10/19/2023 2:20:49 PM ******/
CREATE DATABASE [QLCuaHangLaptop]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'QLCuaHangLaptop', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.DUYGM\MSSQL\DATA\QLCuaHangLaptop.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'QLCuaHangLaptop_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.DUYGM\MSSQL\DATA\QLCuaHangLaptop_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT
GO
ALTER DATABASE [QLCuaHangLaptop] SET COMPATIBILITY_LEVEL = 150
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [QLCuaHangLaptop].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [QLCuaHangLaptop] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [QLCuaHangLaptop] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [QLCuaHangLaptop] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [QLCuaHangLaptop] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [QLCuaHangLaptop] SET ARITHABORT OFF 
GO
ALTER DATABASE [QLCuaHangLaptop] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [QLCuaHangLaptop] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [QLCuaHangLaptop] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [QLCuaHangLaptop] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [QLCuaHangLaptop] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [QLCuaHangLaptop] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [QLCuaHangLaptop] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [QLCuaHangLaptop] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [QLCuaHangLaptop] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [QLCuaHangLaptop] SET  DISABLE_BROKER 
GO
ALTER DATABASE [QLCuaHangLaptop] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [QLCuaHangLaptop] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [QLCuaHangLaptop] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [QLCuaHangLaptop] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [QLCuaHangLaptop] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [QLCuaHangLaptop] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [QLCuaHangLaptop] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [QLCuaHangLaptop] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [QLCuaHangLaptop] SET  MULTI_USER 
GO
ALTER DATABASE [QLCuaHangLaptop] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [QLCuaHangLaptop] SET DB_CHAINING OFF 
GO
ALTER DATABASE [QLCuaHangLaptop] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [QLCuaHangLaptop] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [QLCuaHangLaptop] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [QLCuaHangLaptop] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
EXEC sys.sp_db_vardecimal_storage_format N'QLCuaHangLaptop', N'ON'
GO
ALTER DATABASE [QLCuaHangLaptop] SET QUERY_STORE = ON
GO
ALTER DATABASE [QLCuaHangLaptop] SET QUERY_STORE (OPERATION_MODE = READ_WRITE, CLEANUP_POLICY = (STALE_QUERY_THRESHOLD_DAYS = 30), DATA_FLUSH_INTERVAL_SECONDS = 900, INTERVAL_LENGTH_MINUTES = 60, MAX_STORAGE_SIZE_MB = 1000, QUERY_CAPTURE_MODE = AUTO, SIZE_BASED_CLEANUP_MODE = AUTO, MAX_PLANS_PER_QUERY = 200, WAIT_STATS_CAPTURE_MODE = ON)
GO
USE [QLCuaHangLaptop]
GO
/****** Object:  Table [dbo].[ChiTietHoaDon]    Script Date: 10/19/2023 2:20:49 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChiTietHoaDon](
	[idRieng] [varchar](50) NOT NULL,
	[MaHoaDon] [int] NOT NULL,
	[Gia] [bigint] NOT NULL,
 CONSTRAINT [PK_ChiTietHoaDOn] PRIMARY KEY CLUSTERED 
(
	[idRieng] ASC,
	[MaHoaDon] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ChiTietLapTop]    Script Date: 10/19/2023 2:20:49 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChiTietLapTop](
	[idRieng] [varchar](50) NOT NULL,
	[Gia] [bigint] NOT NULL,
	[NgayNhap] [date] NOT NULL,
	[TrangThai] [nvarchar](50) NOT NULL,
	[MauLaptop] [varchar](50) NOT NULL,
 CONSTRAINT [PK_ChiTietLapTop] PRIMARY KEY CLUSTERED 
(
	[idRieng] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ChiTietPhieu]    Script Date: 10/19/2023 2:20:49 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChiTietPhieu](
	[idRieng] [varchar](50) NOT NULL,
	[MaPhieu] [int] NOT NULL,
	[Gia] [bigint] NOT NULL,
 CONSTRAINT [PK_ChiTietPhieu] PRIMARY KEY CLUSTERED 
(
	[idRieng] ASC,
	[MaPhieu] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HoaDon]    Script Date: 10/19/2023 2:20:49 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HoaDon](
	[MaHoaDon] [int] NOT NULL,
	[NgayLap] [datetime] NOT NULL,
	[TongTien] [bigint] NOT NULL,
	[SoLuong] [int] NOT NULL,
	[NhanVien] [varchar](50) NOT NULL,
	[KhachHang] [varchar](50) NOT NULL,
 CONSTRAINT [PK_HoaDon] PRIMARY KEY CLUSTERED 
(
	[MaHoaDon] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[KhachHang]    Script Date: 10/19/2023 2:20:49 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KhachHang](
	[IdKhachHang] [varchar](50) NOT NULL,
	[Ten] [varchar](50) NOT NULL,
	[SDT] [varchar](50) NOT NULL,
	[TichDiem] [int] NOT NULL,
	[DiaChi] [varchar](50) NOT NULL,
	[TrangThai] [varchar](50) NOT NULL,
 CONSTRAINT [PK_KhachHang] PRIMARY KEY CLUSTERED 
(
	[IdKhachHang] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Laptop]    Script Date: 10/19/2023 2:20:49 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Laptop](
	[id] [varchar](50) NOT NULL,
	[Ten] [nvarchar](50) NOT NULL,
	[SoLuongTonKho] [int] NOT NULL,
	[CPU] [varchar](50) NOT NULL,
	[RAM] [int] NOT NULL,
	[GPU] [varchar](50) NOT NULL,
	[TrangThai] [varchar](50) NOT NULL,
 CONSTRAINT [PK_Laptop] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NhaCungCap]    Script Date: 10/19/2023 2:20:49 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NhaCungCap](
	[IdNCC] [varchar](50) NOT NULL,
	[TenNCC] [nvarchar](50) NOT NULL,
	[DiaChi] [varchar](50) NOT NULL,
	[SDT] [varchar](50) NOT NULL,
	[Email] [varchar](50) NOT NULL,
	[TrangThai] [varchar](50) NULL,
 CONSTRAINT [PK_NhaCungCap] PRIMARY KEY CLUSTERED 
(
	[IdNCC] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NhanVien]    Script Date: 10/19/2023 2:20:49 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NhanVien](
	[idNhanVien] [varchar](50) NOT NULL,
	[TenNhanVien] [nvarchar](50) NOT NULL,
	[SDT] [varchar](50) NOT NULL,
	[DiaChi] [varchar](50) NOT NULL,
	[NgaySinh] [date] NOT NULL,
	[GioiTinh] [bit] NOT NULL,
	[CCCD] [varchar](50) NOT NULL,
	[Email] [varchar](50) NOT NULL,
	[Img_url] [nvarchar](50) ,
	[TrangThai] [varchar](50) NOT NULL,
 CONSTRAINT [PK_NhanVien] PRIMARY KEY CLUSTERED 
(
	[idNhanVien] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[PhieuNhap]    Script Date: 10/19/2023 2:20:49 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PhieuNhap](
	[MaPhieu] [int] NOT NULL,
	[NgayNhap] [datetime] NOT NULL,
	[TongTien] [bigint] NOT NULL,
	[NhaCungCap] [varchar](50) NOT NULL,
	[NhanVien] [varchar](50) NOT NULL,
 CONSTRAINT [PK_PhieuNhap] PRIMARY KEY CLUSTERED 
(
	[MaPhieu] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[TaiKhoan]    Script Date: 10/19/2023 2:20:49 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TaiKhoan](
	[TenDangNhap] [varchar](50) NOT NULL,
	[MatKhau] [varchar](50) NOT NULL,
	[PhanQuyen] [varchar](50) NOT NULL,
 CONSTRAINT [PK_TaiKhoan] PRIMARY KEY CLUSTERED 
(
	[TenDangNhap] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[ChiTietHoaDon]  WITH CHECK ADD  CONSTRAINT [FK_ChiTietHoaDOn_ChiTietLapTop] FOREIGN KEY([idRieng])
REFERENCES [dbo].[ChiTietLapTop] ([idRieng])
GO
ALTER TABLE [dbo].[ChiTietHoaDon] CHECK CONSTRAINT [FK_ChiTietHoaDOn_ChiTietLapTop]
GO
ALTER TABLE [dbo].[ChiTietHoaDon]  WITH CHECK ADD  CONSTRAINT [FK_ChiTietHoaDOn_HoaDon] FOREIGN KEY([MaHoaDon])
REFERENCES [dbo].[HoaDon] ([MaHoaDon])
GO
ALTER TABLE [dbo].[ChiTietHoaDon] CHECK CONSTRAINT [FK_ChiTietHoaDOn_HoaDon]
GO
ALTER TABLE [dbo].[ChiTietLapTop]  WITH CHECK ADD  CONSTRAINT [FK_ChiTietLapTop_Laptop] FOREIGN KEY([MauLaptop])
REFERENCES [dbo].[Laptop] ([id])
GO
ALTER TABLE [dbo].[ChiTietLapTop] CHECK CONSTRAINT [FK_ChiTietLapTop_Laptop]
GO
ALTER TABLE [dbo].[ChiTietPhieu]  WITH CHECK ADD  CONSTRAINT [FK_ChiTietPhieu_ChiTietLapTop] FOREIGN KEY([idRieng])
REFERENCES [dbo].[ChiTietLapTop] ([idRieng])
GO
ALTER TABLE [dbo].[ChiTietPhieu] CHECK CONSTRAINT [FK_ChiTietPhieu_ChiTietLapTop]
GO
ALTER TABLE [dbo].[ChiTietPhieu]  WITH CHECK ADD  CONSTRAINT [FK_ChiTietPhieu_PhieuNhap] FOREIGN KEY([MaPhieu])
REFERENCES [dbo].[PhieuNhap] ([MaPhieu])
GO
ALTER TABLE [dbo].[ChiTietPhieu] CHECK CONSTRAINT [FK_ChiTietPhieu_PhieuNhap]
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [FK_HoaDon_HoaDon] FOREIGN KEY([NhanVien])
REFERENCES [dbo].[NhanVien] ([idNhanVien])
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [FK_HoaDon_HoaDon]
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [FK_HoaDon_KhachHang] FOREIGN KEY([KhachHang])
REFERENCES [dbo].[KhachHang] ([IdKhachHang])
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [FK_HoaDon_KhachHang]
GO
ALTER TABLE [dbo].[PhieuNhap]  WITH CHECK ADD  CONSTRAINT [FK_PhieuNhap_NhaCungCap] FOREIGN KEY([NhaCungCap])
REFERENCES [dbo].[NhaCungCap] ([IdNCC])
GO
ALTER TABLE [dbo].[PhieuNhap] CHECK CONSTRAINT [FK_PhieuNhap_NhaCungCap]
GO
ALTER TABLE [dbo].[PhieuNhap]  WITH CHECK ADD  CONSTRAINT [FK_PhieuNhap_NhanVien] FOREIGN KEY([NhanVien])
REFERENCES [dbo].[NhanVien] ([idNhanVien])
GO
ALTER TABLE [dbo].[PhieuNhap] CHECK CONSTRAINT [FK_PhieuNhap_NhanVien]
GO
ALTER TABLE [dbo].[TaiKhoan]  WITH CHECK ADD  CONSTRAINT [FK_TaiKhoan_TaiKhoan] FOREIGN KEY([TenDangNhap])
REFERENCES [dbo].[NhanVien] ([idNhanVien])
GO
ALTER TABLE [dbo].[TaiKhoan] CHECK CONSTRAINT [FK_TaiKhoan_TaiKhoan]
GO
USE [master]
GO
ALTER DATABASE [QLCuaHangLaptop] SET  READ_WRITE 
GO

-- Thêm dữ liệu vào bảng Laptop
INSERT INTO Laptop (id, Ten, SoLuongTonKho, CPU, RAM, GPU, TrangThai)
VALUES
	('LAP001', N'Laptop Dell XPS 13', 0, 'Intel Core i7', 16, 'Intel UHD Graphics', '0'),
    ('LAP002', N'Laptop HP Spectre x360', 0, 'Intel Core i5', 8, 'Intel Iris Xe Graphics', '0'),
    ('LAP003', N'Laptop ASUS ROG Zephyrus G14', 0, 'AMD Ryzen 9', 32, 'NVIDIA GeForce RTX 3060', '0'),
    ('LAP004', N'Laptop Lenovo ThinkPad X1 Carbon', 0, 'Intel Core i7', 16, 'Intel UHD Graphics', '0'),
    ('LAP005', N'Laptop MSI GS66 Stealth', 0, 'Intel Core i9', 32, 'NVIDIA GeForce RTX 3080', '0'),
    ('LAP006', N'Laptop Acer Aspire 5', 5, 'AMD Ryzen 5', 8, 'AMD Radeon Graphics', '1'),
    ('LAP007', N'Laptop Apple MacBook Pro', 3, 'Apple M1', 16, 'Apple GPU', '1'),
    ('LAP008', N'Laptop Lenovo Ideapad 3', 4, 'AMD Ryzen 3', 4, 'AMD Radeon Graphics', '1'),
    ('LAP009', N'Laptop Microsoft Surface Laptop 4', 6, 'Intel Core i7', 16, 'Intel Iris Xe Graphics', '1'),
    ('LAP010', N'Laptop Dell Inspiron 15', 4, 'Intel Core i5', 8, 'Intel UHD Graphics', '1'),
    ('LAP011', N'Laptop HP Envy x360', 0, 'AMD Ryzen 7', 16, 'AMD Radeon Graphics', '0'),
    ('LAP012', N'Laptop ASUS VivoBook 14', 0, 'Intel Core i3', 8, 'Intel UHD Graphics', '0'),
    ('LAP013', N'Laptop MSI GF65 Thin', 0, 'Intel Core i7', 16, 'NVIDIA GeForce GTX 1660 Ti', '0'),
    ('LAP014', N'Laptop Acer Predator Helios 300', 0, 'Intel Core i7', 16, 'NVIDIA GeForce RTX 3060', '0'),
    ('LAP015', N'Laptop Razer Blade 15', 0, 'Intel Core i9', 32, 'NVIDIA GeForce RTX 3080', '0'),
    ('LAP016', N'Laptop LG Gram 17', 0, 'Intel Core i7', 16, 'Intel Iris Xe Graphics', '0'),
    ('LAP017', N'Laptop MSI Prestige 14', 0, 'Intel Core i5', 16, 'NVIDIA GeForce GTX 1650', '0'),
    ('LAP018', N'Laptop Lenovo Legion 5', 0, 'AMD Ryzen 7', 16, 'NVIDIA GeForce RTX 3060', '0'),
    ('LAP019', N'Laptop HP Pavilion', 0, 'Intel Core i3', 8, 'Intel UHD Graphics', '0'),
    ('LAP020', N'Laptop Dell G5', 0, 'Intel Core i7', 16, 'NVIDIA GeForce GTX 1660 Ti', '0');


-- Mẫu Laptop 'LAP006' (Acer Aspire 5)
INSERT INTO ChiTietLapTop (idRieng, Gia, NgayNhap, TrangThai, MauLaptop)
VALUES
    ('LAP006-001', 7500000, '2023-11-01', N'1', 'LAP006'),
    ('LAP006-002', 7500000, '2023-11-01', N'1', 'LAP006'),
    ('LAP006-003', 7500000, '2023-11-01', N'1', 'LAP006'),
    ('LAP006-004', 7500000, '2023-11-01', N'1', 'LAP006'),
    ('LAP006-005', 7500000, '2023-11-01', N'1', 'LAP006'),

    ('LAP007-001', 22000000, '2023-11-02', N'1', 'LAP007'),
    ('LAP007-002', 22000000, '2023-11-02', N'1', 'LAP007'),
    ('LAP007-003', 22000000, '2023-11-02', N'1', 'LAP007'),

    ('LAP008-001', 5500000, '2023-11-03', N'1', 'LAP008'),
    ('LAP008-002', 5500000, '2023-11-03', N'1', 'LAP008'),
    ('LAP008-003', 5500000, '2023-11-03', N'1', 'LAP008'),
    ('LAP008-004', 5500000, '2023-11-03', N'1', 'LAP008'),

    ('LAP009-001', 18000000, '2023-11-04', N'1', 'LAP009'),
    ('LAP009-002', 18000000, '2023-11-04', N'1', 'LAP009'),
    ('LAP009-003', 18000000, '2023-11-04', N'1', 'LAP009'),
    ('LAP009-004', 18000000, '2023-11-04', N'1', 'LAP009'),
    ('LAP009-005', 18000000, '2023-11-04', N'1', 'LAP009'),
    ('LAP009-006', 18000000, '2023-11-04', N'1', 'LAP009'),

    ('LAP010-001', 6500000, '2023-11-06', N'1', 'LAP010'),
    ('LAP010-002', 6500000, '2023-11-06', N'1', 'LAP010'),
    ('LAP010-003', 6500000, '2023-11-06', N'1', 'LAP010'),
    ('LAP010-004', 6500000, '2023-11-06', N'1', 'LAP010');

-- Thêm thông tin cho 3 nhân viên vào bảng NhanVien
INSERT INTO NhanVien (idNhanVien, TenNhanVien, SDT, DiaChi, NgaySinh, GioiTinh, CCCD, Email, Img_url, TrangThai)
VALUES
    ('NV001', N'Trần Khánh Duy', '0123456789', 'Địa chỉ A', '2003-10-26', 1, '080203010013', 'trankhanhduy12a12@gmail.com', NULL, '1'),
    ('NV002', N'Lê Trung Kiên', '0987654321', 'Địa chỉ B', '1992-03-20', 0, '9876543210', 'email2@example.com', NULL, '1'),
    ('NV003', N'Lê Hoài Nam', '0123456789', 'Địa chỉ C', '2003-06-10', 1, '111122223333', 'email3@example.com', NULL, '0');

Insert into TaiKhoan (TenDangNhap, MatKhau, PhanQuyen)
values 
	('NV001', '123', 'Quanly'),
	('NV002', '123', 'BanHang'),
	('NV003', '123', 'BanHang');


INSERT INTO NhaCungCap (IdNCC, TenNCC, DiaChi, SDT, Email, TrangThai)
VALUES
    ('NCC001', N'DELL', 'Địa chỉ DELL', '0123456789', 'dell@example.com', '1'),
    ('NCC002', N'ACER', 'Địa chỉ ACER', '0987654321', 'acer@example.com', '1'),
    ('NCC003', N'ASUS', 'Địa chỉ ASUS', '0123456789', 'asus@example.com', '1'),
    ('NCC004', N'HP', 'Địa chỉ HP', '0987654321', 'hp@example.com', '1'),
    ('NCC005', N'APPLE', 'Địa chỉ APPLE', '0987654321', 'apple@example.com', '1'),
    ('NCC006', N'LENOVO', 'Địa chỉ LENOVO', '0987654321', 'lenovo@example.com', '1');

-- Tạo dữ liệu cho bảng PhieuNhap
INSERT INTO PhieuNhap (MaPhieu, NgayNhap, TongTien, NhaCungCap, NhanVien)
VALUES
    (1, '2023-11-01 10:00:00', 40000000, 'NCC002', 'NV002'),
    (2, '2023-11-02 11:30:00', 80000000, 'NCC005', 'NV003'),
    (3, '2023-11-03 14:15:00', 60000000, 'NCC006', 'NV003');

-- Tạo dữ liệu cho bảng ChiTietPhieu dựa trên các mẫu laptop
-- PhieuNhap 1 (Mẫu Laptop: Acer Aspire 5)
INSERT INTO ChiTietPhieu (idRieng, MaPhieu, Gia)
VALUES
    ('LAP006-001', 1, 7500000),
    ('LAP006-002', 1, 7500000),
    ('LAP006-003', 1, 7500000),
    ('LAP006-004', 1, 7500000),
    ('LAP006-005', 1, 7500000);

-- PhieuNhap 2 (Mẫu Laptop: Apple MacBook Pro)
INSERT INTO ChiTietPhieu (idRieng, MaPhieu, Gia)
VALUES
    ('LAP007-001', 2, 22000000),
    ('LAP007-002', 2, 22000000),
    ('LAP007-003', 2, 22000000);

-- PhieuNhap 3 (Mẫu Laptop: Lenovo Ideapad 3)
INSERT INTO ChiTietPhieu (idRieng, MaPhieu, Gia)
VALUES
    ('LAP008-001', 3, 5500000),
    ('LAP008-002', 3, 5500000),
    ('LAP008-003', 3, 5500000),
    ('LAP008-004', 3, 5500000);

-- Them khach hang
INSERT INTO [dbo].[KhachHang] ([idKhachHang],[Ten], [SDT], [TichDiem], [DiaChi], [TrangThai])
VALUES ('0987654321','Nguyen Van A', '0987654321', 100, '123 Duong ABC', '1'),
('0901234567','Tran Thi B', '0901234567', 50, '456 Duong XYZ', '1'),
('0912345678','Le Van C', '0912345678', 75, '789 Duong LMN', '1'),
('0976543210','Pham Thi D', '0976543210', 30, '111 Duong DEF', '1');
