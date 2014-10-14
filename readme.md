Sonny Lazuardi Hermawan (13511029)
Genta Indra Winata (13511094)

# Petunjuk Penggunaan

File rules.txt harus berada pada direktori yang sama dengan parser.jar

Jalankan program dengan mengetikkan perintah berikut

    java -jar parser.jar

Masukkan kalimat yang akan diproses pada text input aplikasi. Tekan tombol 'Cek' untuk memulai proses. Setelah itu, akan muncul hasil kalimat itu sesuai grammar atau tidak. Lalu, akan muncul tree yang merupakan struktur CYK.

Untuk mengubah rule, edit file rules.txt. Rule ditulis dalam bentuk regular form CYK. Contohnya adalah sebagai berikut.

    ModVPlace -> ModV PrepPlace
    ModV -> Modal Verb | Modal VEx | NegModal Verb | NegModal VEx
    ModAdj -> Modal Adj | Modal AdjN | Modal NegAdj




