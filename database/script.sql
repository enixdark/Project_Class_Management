USE [QLD]
GO
/****** Object:  Table [dbo].[Account]    Script Date: 10/17/2013 17:06:15 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Account](
	[username] [varchar](20) NOT NULL,
	[pass] [varchar](20) NOT NULL,
	[advance] [int] NULL,
 CONSTRAINT [pk_key] PRIMARY KEY CLUSTERED 
(
	[username] ASC,
	[pass] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[hocki]    Script Date: 10/17/2013 17:06:15 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[hocki](
	[mahk] [varchar](50) NOT NULL,
	[tenhk] [nvarchar](100) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[mahk] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[heDaotao]    Script Date: 10/17/2013 17:06:15 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[heDaotao](
	[mahe] [varchar](50) NOT NULL,
	[tenhe] [nvarchar](100) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[mahe] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Nganh]    Script Date: 10/17/2013 17:06:15 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Nganh](
	[Manganh] [varchar](10) NOT NULL,
	[TenNganh] [nvarchar](50) NULL,
 CONSTRAINT [PK_Nganh] PRIMARY KEY CLUSTERED 
(
	[Manganh] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Monhoc]    Script Date: 10/17/2013 17:06:15 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Monhoc](
	[Mamon] [varchar](50) NOT NULL,
	[tenMon] [nvarchar](100) NOT NULL,
	[soTinchi] [int] NOT NULL,
	[maHK] [varchar](50) NOT NULL,
	[MaNganh] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[Mamon] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[lop]    Script Date: 10/17/2013 17:06:15 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[lop](
	[malop] [varchar](50) NOT NULL,
	[mahe] [varchar](50) NOT NULL,
	[tenlop] [varchar](50) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[malop] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[diem]    Script Date: 10/17/2013 17:06:15 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[diem](
	[masv] [varchar](50) NOT NULL,
	[mamon] [varchar](50) NOT NULL,
	[mahk] [varchar](50) NOT NULL,
	[diemqt] [float] NOT NULL,
	[Diemlan1] [float] NOT NULL,
	[diemlan2] [float] NOT NULL,
	[diemtb] [float] NOT NULL,
	[namhoc] [smallint] NULL,
 CONSTRAINT [pk_diem] PRIMARY KEY CLUSTERED 
(
	[masv] ASC,
	[mamon] ASC,
	[mahk] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[sinhvien]    Script Date: 10/17/2013 17:06:15 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[sinhvien](
	[masv] [varchar](50) NOT NULL,
	[malop] [varchar](50) NOT NULL,
	[mahe] [varchar](50) NOT NULL,
	[mahk] [varchar](50) NOT NULL,
	[hoten] [nvarchar](50) NOT NULL,
	[ngaysinh] [datetime] NOT NULL,
	[que] [varchar](50) NOT NULL,
	[gioitinh] [bit] NULL,
PRIMARY KEY CLUSTERED 
(
	[masv] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[thongke]    Script Date: 10/17/2013 17:06:15 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[thongke](
	[masv] [varchar](50) NOT NULL,
	[mahk] [varchar](50) NOT NULL,
	[malop] [varchar](50) NOT NULL,
	[diemtb] [float] NOT NULL,
	[diemtl] [float] NOT NULL,
 CONSTRAINT [pk_thongke] PRIMARY KEY CLUSTERED 
(
	[masv] ASC,
	[mahk] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  ForeignKey [FK__diem__mamon__2F10007B]    Script Date: 10/17/2013 17:06:15 ******/
ALTER TABLE [dbo].[diem]  WITH CHECK ADD FOREIGN KEY([mamon])
REFERENCES [dbo].[Monhoc] ([Mamon])
GO
/****** Object:  ForeignKey [FK__lop__mahe__182C9B23]    Script Date: 10/17/2013 17:06:15 ******/
ALTER TABLE [dbo].[lop]  WITH CHECK ADD FOREIGN KEY([mahe])
REFERENCES [dbo].[heDaotao] ([mahe])
GO
/****** Object:  ForeignKey [FK__Monhoc__maHK__0F975522]    Script Date: 10/17/2013 17:06:15 ******/
ALTER TABLE [dbo].[Monhoc]  WITH CHECK ADD FOREIGN KEY([maHK])
REFERENCES [dbo].[hocki] ([mahk])
GO
/****** Object:  ForeignKey [FK__sinhvien__malop__276EDEB3]    Script Date: 10/17/2013 17:06:15 ******/
ALTER TABLE [dbo].[sinhvien]  WITH CHECK ADD FOREIGN KEY([malop])
REFERENCES [dbo].[lop] ([malop])
GO
/****** Object:  ForeignKey [FK__thongke__mahk__2B3F6F97]    Script Date: 10/17/2013 17:06:15 ******/
ALTER TABLE [dbo].[thongke]  WITH CHECK ADD FOREIGN KEY([mahk])
REFERENCES [dbo].[hocki] ([mahk])
GO
/****** Object:  ForeignKey [FK__thongke__masv__2A4B4B5E]    Script Date: 10/17/2013 17:06:15 ******/
ALTER TABLE [dbo].[thongke]  WITH CHECK ADD FOREIGN KEY([masv])
REFERENCES [dbo].[sinhvien] ([masv])
GO
