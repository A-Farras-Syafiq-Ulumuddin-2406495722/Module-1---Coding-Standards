# Reflection 1

Pembuatan dua fitur baru yaitu edit-product dan delete-product awalnya sangat sulit
karena ini pertama kalinya saya menggunakan Spring Boot. Meminimalkan penggunaan AI, 
saya akhirnya meminta tolong teman untuk melihat source code miliknya serta diajari dengannya.

Selama saya kerjakan kode ini, saya mulai merasa kode yang saya lihat 
lebih mudah setelah menggunakan salah satu teknik clean code yaitu pemilihan nama yang tepat.
Sebagai contoh,
* editProductPost digunakan untuk mengubah properti dari suatu produk
* editProductPage digunakan untuk menampilkan halaman untuk manusia bisa interaksi mengubah properti produk

Kedua method meski mirip tetapi punya fungsi yang berbeda dan ini juga mengandung
prinsip clean code yang lain bahwa fungsi harus fokus ke satu task. 

# Reflection 2

1) Saya merasa cukup exhausting karena menggunakan unit-test sendiri bebannya bisa eksponensial.
Untuk bagaimana kita tahu bahwa unit test itu cukup yaitu lakukan testing untuk hampir setiap line of code yang ditulis.
Lalu bagaimana bila code coverage 100%? Tidak bisa dipercayakan karena saya rasa kualitas kode tidak bisa sepenuhnya
dicek menggunakan unit-test.


