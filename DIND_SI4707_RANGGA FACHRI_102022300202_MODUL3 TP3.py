#TP Nomor 1
print("Program Menghitung Nilai Rata-Rata Siswa")
totalnilai = 0
jumlahsiswa = int(input("Masukkan Jumlah dari siswa yang ingin dihitung : "))

for i in range(jumlahsiswa):
    nilai = int(input(f"Masukkan nilai ke-{i+1} dari siswa yang ingin dihitung : "))
    totalnilai += nilai
    if nilai > 100:
        totalnilai = 0
        print ("Masukkan nilai yang valid dengan range 0-100")
        print ("Silahkan coba run lagi program ini")
        break

print(f"Rata-rata nilai yang didapat adalah sebesar : {totalnilai/jumlahsiswa}")

#TP Nomor 2
print("Program Penghitung Tabungan dari Gaji")
target = int(input("Masukkan Target dari tabungan anda : Rp."))
waktu = int(input("Masukkan waktu untuk mencapai target anda : "))
total_tabungan = 0

while total_tabungan < target:
    for i in range(waktu):
        tabungan = int(input(f"Masukkan tabungan anda yang ke-{i+1} : Rp."))
        total_tabungan += tabungan

    if total_tabungan >= target:
        print("Selamat anda telah mencapai target tabungan anda")
        print(f"Saat ini anda memiliki tabungan sebesar : Rp.{total_tabungan}")
    else:
        print(f"Tabungan anda kurang Rp.{target-total_tabungan} dari target sebesar Rp.{target}")
        print("Anda belum mencapai target tabungan anda. Tetap Semangat dan coba lagi")
        break