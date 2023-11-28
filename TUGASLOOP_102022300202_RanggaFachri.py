#Perulangan For
x = 4
for p in range(x):
    print (f"Perulangan {p}")

#Perulangan While
awal = 1
batas = 9
while awal <= batas:
    print(f"Angka ganjil : {awal}")
    awal=awal+2    

#Perulangan Nested Loop
while True:
    nama = input("Masukkan nama : ")
    if nama == "Rangga Fachri":
        print ("lanjut")
        
    elif nama != "Rangga Fachri":
        print ("yang bener dong, ulang lagi")
        continue
    
    tahun_lahir = int(input("Masukkan Tahun lahirmu : "))
    if tahun_lahir == 2004:
        print ("Selamat Benar Semua!!!")
        break
    elif tahun_lahir != 2004:
        print ("ulang lagi dari awal")
        continue

    