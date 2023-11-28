angka = int(input("Masukkan Angka : "))
if angka % 2 == 0:
    print(f"Angka yang anda input, {angka} adalah bilangan Genap")
else:
    print(f"Angka yang anda input, {angka} adalah bilangan Ganjil")

nilai = int(input("Masukkan Nilai Anda : "))
if nilai >= 80 and nilai <= 100:
    print("Anda mendapatkan indeks A")
elif nilai >= 70 and nilai <= 79:
    print("Anda mendapatkan indeks AB")
elif nilai >= 60 and nilai <= 69:
    print("Anda mendapatkan indeks B")
elif nilai >= 50 and nilai <= 59:
    print("Anda mendapatkan indeks BC")
elif nilai >= 40 and nilai <= 49:
    print("Anda mendapatkan indeks C")
elif nilai >= 30 and nilai <= 39:
    print("Anda mendapatkan indeks D")
elif nilai >= 0 and nilai <= 29:
    print("Anda mendapatkan indeks E")
else:
    print("Nilai yang dimasukkan Invalid")