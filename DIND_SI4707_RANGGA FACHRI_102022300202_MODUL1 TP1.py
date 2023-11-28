"""Pak Dengklek mempunyai ikan cupang sebanyak N. Ia ingin
membagikan koleksi ikan cupangnya kepada cucu-cucunya yang
berjumlah M. Ternyata, jumlah ikan cupang Pak Dengklek lebih
banyak daripada jumlah cucunya. Bantulah Pak Dengklek untuk
menentukan berapa ekor cupang yang harus dia berikan kepada
masing-masing cucunya, dan berapa sisanya."""

cupang = int(input("Masukkan jumlah ikan cupang: "))
cucu = int(input("Masukkan jumlah Cucu Pak Dengklek: "))
print ("Setiap cucu dapat ikan cupang sebanyak", cupang // cucu)
print ("Sisa ikan cupang", cupang % cucu)


"""Pak Guts adalah seorang pengrajin senjata yang sangat suka
sekali membuat senjata di halaman belakang rumahnya. Suatu
hari, Pak Guts ingin membuat dua buah lingkaran yang berbeda
ukuran untuk alas dari senjatanya. Ketika mulai membuat kedua
lingkaran tersebut, Pak Guts kebingungan dan sadar bahwa dia
harus menghitung masing-masing luas lingkaran tersebut dan
membandingkan mana yang lebih besar. Bantulah Pak Guts untuk
membuat program yang dapat menghitung luas lingkaran dan
membandingkannya."""

phi = 3.14
r1 = int(input("Masukkan jaring-jaring lingkaran1: " ))

Luas1 = phi * (r1 ** 2)
r2 = int(input("Masukkan jaring-jaring lingkaran2: " ))

Luas2 = phi * (r2 ** 2)
print(f"Luas lingkaran pertama adalah {Luas1} dan Luas lingkaran kedua adalah {Luas2}")


"""Pak Luffy adalah seorang dosen yang memiliki banyak
mahasiswa. Beliau memerintahkan kamu sebagai asistennya
untuk membuat program menghitung nilai mahasiswanya. Pak
Luffy memberitahumu bahwa nilai yang perlu dihitung dari mata
kuliah yang diempunya adalah rata-rata dari nilai tugas, quiz,
UTS, dan juga UAS milik masing-masing mahasiswa. Buatlah
program untuk menghitung rata-rata nilainya dan inputan data
diri mahasiswa untuk memudahkan kamu membantu Pak Luffy."""

Nama = input("Masukkan Nama Mahasiswa: ")
NIM = int(input("Masukkan NIM: "))
Kelas = input("Masukkan kelas Mahasiswa: ")
Tugas = int(input("Masukkan Nilai Tugas: "))
Quiz = int(input("Masukkan Nilai Quiz: "))
UTS = int(input("Masukkan Nilai UTS: "))
UAS = int(input("Masukkan Nilai UAS: "))
Nilai = ( Tugas + Quiz + UTS + UAS) / 4

print (f"Atas nama {Nama} dengan NIM {NIM} dari kelas {Kelas} mendapatkan nilai : {Nilai} pada MK Sistem Enterprise") 

