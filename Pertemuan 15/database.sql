CREATE DATABASE IF NOT EXISTS perpustakaan_pbo;
USE perpustakaan_pbo;
CREATE TABLE IF NOT EXISTS buku(
  id_buku INT NOT NULL AUTO_INCREMENT,
  judul VARCHAR(45) NOT NULL,
  pengarang VARCHAR(45) NOT NULL,
  PRIMARY KEY (id_buku)
);
INSERT INTO buku (judul, pengarang) VALUES
('Belajar Pemrograman Java dari Nol', 'Petani Kode'),
('Pemrograman Java Menggunakan Linux', 'Petani Kode');