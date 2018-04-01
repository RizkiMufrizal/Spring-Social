# Spring-Social

## Cara Menjalankan

1. Akses folder project
2. jalankan dengan perintah `gradle bootRun`, aplikasi jalan di port 8443 dengan SSL

## Cara membuat certificate

1. generate jks dengan perintah

```bash
keytool -genkey -keyalg RSA -alias selfsigned -keystore keystore.jks -storepass 123456 -validity 360 -keysize 2048
```

2. Lihat list jks

```bash
keytool -v -list -keystore keystore.jks
```

3. Generate crt

```bash
keytool -exportcert -rfc -alias selfsigned -keystore keystore.jks -file selfsigned.crt
```

4. Print hasil crt

```bash
keytool -printcert -file selfsigned.crt
```
