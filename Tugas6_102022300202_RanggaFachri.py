 
print("kursi_single, meja_kecil, meja_besar, kursi_double, bed_single, bed_double")
pilihan_barang = { "kursi_single" : 200000,
                  "meja_kecil" : 300000,
                  "meja_besar" : 400000,
                  "kursi_double" : 300000,
                  "bed_single" : 250000,
                  "bed_double" : 450000,
                  }
print(pilihan_barang)
b1 = input("masukkan barang pertama yang anda beli: ")
b2 = input("masukkan barang kedua yang anda beli: ")
total_belanja = pilihan_barang[b1] + pilihan_barang[b2]
print(f"Total belanjaan anda sebesar Rp : {total_belanja}")

if total_belanja > 534000:
    print("Karena belanjaan kamu lebih dari 534000 maka kamu terkena pajak sebesar 7%")
    pajak = (total_belanja * 7/100)
    bayar = (total_belanja + pajak)
    print(f"anda terkena pajak sebesar 7% dari total belanja yaitu sebesar : Rp.{pajak} " ) 
    print(f"Total belanjaan yang harus dibayar sebesar : Rp.{bayar} ")
 
else:
    print(f"anda tidak terkena pajak karena total anda sebesar : Rp. {total_belanja} dan kurang dari 534000")

if total_belanja > 572000: 
    print("Karena total belanja kamu lebih dari 572000 maka kamu akan mendapat voucher diskon sebesar Rp. 100000")
  
else:
    print("Kamu tidak mendapat voucher")




