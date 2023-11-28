#NIM : 102022300202
#Nama : Rangga Fachri

#Program Pembelian
print("Selamat datang di Warung Makan RF, berikut menu yang kami sediakan")
mm_0202 = input("Anda ingin membeli (Makanan/Minuman) : ")
if mm_0202 == "Makanan":
    print("MENU MAKANAN")
    print("Nasi Goreng : Rp.80000")
    print("Mie Goreng : Rp.100000")
    print("Ayam Kremes : Rp.85000")
    print("Ayam Bakar : Rp.95000")
    print("Ikan Bakar : Rp.88000")
    pma_0202 = { "Nasi Goreng" : 80000,
                  "Mie Goreng" : 100000,
                  "Ayam Kremes" : 85000,
                  "Ayam Bakar" : 95000,
                  "Ikan Bakar" : 88000,
                  }
    
    beli_0202 = input("Masukkan Makanan yang anda pilih : ")
    q_0202 = int(input("Masukkan Jumlah dari makanan yang ingin dibeli : "))
    harga_0202 = pma_0202[beli_0202] * q_0202
    print (f"Informasi Pembelian anda yaitu {beli_0202} sebanyak {q_0202} dengan harga per item {pma_0202[beli_0202]}")
    print ("Total belanjaan yang harus anda bayar sebesar Rp.",harga_0202)
    if harga_0202 > 100000 and harga_0202 < 250001:
        d_0202 = harga_0202 * 10/100
        hd_0202 = harga_0202 - d_0202
        print (f"Anda mendapat diskon 10% yang membuat harga belanjaan anda menjadi Rp.{hd_0202}")
    elif harga_0202 > 250000 and harga_0202 < 500001:
        d_0202 = harga_0202 * 15/100
        hd_0202 = harga_0202 - d_0202
        print (f"Anda mendapat diskon 15% yang membuat harga belanjaan anda menjadi Rp.{hd_0202}")
    elif harga_0202 > 500000:
        d_0202 = harga_0202 * 25/100
        hd_0202 = harga_0202 - d_0202
        print (f"Anda mendapat diskon 25% yang membuat harga belanjaan anda menjadi Rp.{hd_0202}")
    elif harga_0202 <= 100000:
        hd_0202 = harga_0202
        print ("Anda tidak mendapat diskon")            

elif mm_0202 == "Minuman":
    print("MENU MINUMAN")
    print("TehEs : Rp.90000")
    print("HotChocolate : Rp.95000")
    print("LatteArt : Rp.150000")
    print("AirPutih : Rp.85000")
    print("KopiLuwak : Rp.200000")
    pmi_0202 = { "TehEs" : 90000,
                  "HotChocolate" : 95000,
                  "LatteArt" : 150000,
                  "AirPutih" : 85000,
                  "KopiLuwak" : 200000,
                  }
    beli_0202 = input("Masukkan Minuman yang anda pilih : ")
    q_0202 = int(input("Masukkan Jumlah dari minuman yang ingin dibeli : "))
    harga_0202 = pmi_0202[beli_0202] * q_0202
    print (f"Informasi Pembelian anda yaitu {beli_0202} sebanyak {q_0202} dengan harga per item {pmi_0202[beli_0202]}")
    print ("Total belanjaan yang harus anda bayar sebesar Rp.",harga_0202)
    if harga_0202 > 100000 and harga_0202 < 250001:
        d_0202 = harga_0202 * 10/100
        hd_0202 = harga_0202 - d_0202
        print (f"Anda mendapat diskon 10% yang membuat harga belanjaan anda menjadi Rp.{hd_0202}")
    elif harga_0202 > 250000 and harga_0202 < 500001:
        d_0202 = harga_0202 * 15/100
        hd_0202 = harga_0202 - d_0202
        print (f"Anda mendapat diskon 15% yang membuat harga belanjaan anda menjadi Rp.{hd_0202}")
    elif harga_0202 > 500000:
        d_0202 = harga_0202 * 25/100
        hd_0202 = harga_0202 - d_0202
        print (f"Anda mendapat diskon 25% yang membuat harga belanjaan anda menjadi Rp.{hd_0202}")  
    elif harga_0202 <= 100000:
        hd_0202 = harga_0202
        print ("Anda tidak mendapat diskon")

input ("Masukkan Nama anda : ")
input ("Masukkan NIM anda : ")
bayar_0202 = int(input("Masukkan Nominal Pembayaran : Rp."))
if bayar_0202 < hd_0202 :
    print("Uang anda tidak mencukupi :)")
else : 
    print (f"Uang anda Rp.{bayar_0202} maka kembalian sebesar Rp.{bayar_0202 - hd_0202}" )        


#Program ATM Sederhana
nim_0202 = 102022300202
nama_0202 = "Rangga Fachri"
pin_0202 = 300202
norek_0202 = 1480020385418
s_0202 = 1000000
ip_0202 = int(input("Masukkan PIN : "))
if ip_0202 == 300202:
    print("MENU UTAMA")
    print(">Cek Saldo")
    print(">Tarik Uang")
    print(">Setor Uang")
    mu_0202 = input("Ketik Menu yang ingin dituju : ")
    if mu_0202 == "Cek Saldo":
        print(f"NIM : {nim_0202}")
        print(f"Nama : {nama_0202}")
        print(f"Nomor Rekening : {norek_0202}")
        print("Anda memiliki saldo sebesar : Rp.",s_0202)

    elif mu_0202 == "Tarik Uang":
        print(f"NIM : {nim_0202}")
        print(f"Nama : {nama_0202}")
        print(f"Nomor Rekening : {norek_0202}")
        ntu_0202 = int(input("Masukkan Nominal yang ingin ditarik : Rp."))
        print (f"Saldo anda tersisa Rp.{s_0202 - ntu_0202}")

    elif mu_0202 == "Setor Uang":
        print(f"NIM : {nim_0202}")
        print(f"Nama : {nama_0202}")
        print(f"Nomor Rekening : {norek_0202}")
        nsu_0202 = int(input("Masukkan Nominal yang ingin disetor : Rp."))
        print (f"Saldo anda menjadi Rp.{s_0202 + nsu_0202}")
else:
    print("PIN yang anda masukkan tidak valid, mohon coba lagi")
