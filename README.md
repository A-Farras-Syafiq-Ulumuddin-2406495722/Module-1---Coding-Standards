# Module 1

### Reflection 1

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

### Reflection 2

1) Saya merasa cukup exhausting karena menggunakan unit-test sendiri bebannya bisa eksponensial.
Untuk bagaimana kita tahu bahwa unit test itu cukup yaitu lakukan testing untuk hampir setiap line of code yang ditulis.
Lalu bagaimana bila code coverage 100%? Tidak bisa dipercayakan karena saya rasa kualitas kode tidak bisa sepenuhnya
dicek menggunakan unit-test.

# Module 2

### Note for Code Coverage
- 22:08 14/02/2026 → Coverage at 46%

### List of Code Quality Issues
- 7x issue related to unit test having too many assert (fixed)
- 3x issue related to unit test should be package-private (fixed)
- 2x issue related to duplicate literals
- 1x issue related to unit test does not has assert 

Issue yang diberikan dengan menggunakan tools PMD ini sebagian besar
berada di unit test maka rencananya:
- Untuk unit test yang assert nya banyak, diperbagi lagi sehingga tiap unit test hanya satu assert
- Unit test tidak memiliki assert, tambahkan assert
- Untuk yang issue package-private, bagian public di nama class nya dihapuskan

### CI/CD
