# Management Parkir API

Latihan Membuat sistem management Parkir, Dari data mobil, set Slot parkir masih tersedia atau tidak dan Menentukan jumlah pembayaran ketika keluar.

---

## Table of Contents (Optional)

> If your `README` has a lot of info, section headers might be nice.

-  [Installation](#installation)
-  [Features](#features)
-  [Contributing](#contributing)
-  [Team](#team)
-  [FAQ](#faq)
-  [Support](#support)
-  [License](#license)

---

## Repository Title Goes Here

> Subtitle or Short Description Goes Here

> ideally one sentence

> include terms/tags that can be searched

[![Build Status](http://img.shields.io/travis/badges/badgerbadgerbadger.svg?style=flat-square)](https://travis-ci.org/badges/badgerbadgerbadger)
[![Dependency Status](http://img.shields.io/gemnasium/badges/badgerbadgerbadger.svg?style=flat-square)](https://gemnasium.com/badges/badgerbadgerbadger)
[![Coverage Status](http://img.shields.io/coveralls/badges/badgerbadgerbadger.svg?style=flat-square)](https://coveralls.io/r/badges/badgerbadgerbadger)
[![Gem Version](http://img.shields.io/gem/v/badgerbadgerbadger.svg?style=flat-square)](https://rubygems.org/gems/badgerbadgerbadger)

[![Build Status](https://travis-ci.org/akashnimare/foco.svg?branch=master)](https://travis-ci.org/akashnimare/foco)

**Environmet Sederhana**

-  Port :8088

-  URL Kendaraan : http://localhost:8088/api/kendaraan/?

-  URL Parkir : http://localhost:8088/api/parkir/?

-  Most people will glance at your `README`, _maybe_ star it, and leave

---

## Example (Optional)

```java
// code away!
  @GetMapping("warnaArray")
  public ResponseEntity<?> getArrayPlat(@RequestParam("warna") String warna) {
    Map<String, String[]> data = kendaraanService.getResponseByWarnaArray(warna);
    return new ResponseEntity<>(data, HttpStatus.OK);
  }
};
```

```java
#Property Url
@kendaraan_url = http://localhost:8088/api/kendaraan
@parkir_url = http://localhost:8088/api/parkir

### Get All data Kendaraan Wheer isKeluar = false
GET {{kendaraan_url}}/all HTTP/1.1

### Get Kendaraan By Id (Optional)
GET {{kendaraan_url}}/4 HTTP/1.1

### Get View Response Kendraan
GET {{kendaraan_url}}/response HTTP/1.1

#Propertu Tambahan
@nomor_plat=B 113 QW
@warna_mobil=hitam
@tipe=mpv

### Get Reponse By Plat Nomor
GET {{kendaraan_url}}/plat?noPlat={{nomor_plat}} HTTP/1.1

### Search Kendaraan By Plat  Nomor
GET {{kendaraan_url}}/search?plat={{nomor_plat}} HTTP/1.1

### Kendaraan Keluar => set parkir slot menjadi available => set keluar kendaraan = true
GET {{kendaraan_url}}/keluar?platNomor={{nomor_plat}} HTTP/1.1

### Cek status Kendaraan (Optional)
GET {{kendaraan_url}}/status?platNomor={{nomor_plat}} HTTP/1.1

### Serach Plat nomor by warna result As List
GET {{kendaraan_url}}/warna?warna={{warna_mobil}} HTTP/1.1

### Search Plat nomor by Warna result As Map<String, String[]>
GET {{kendaraan_url}}/warnaArray?warna={{warna_mobil}} HTTP/1.1

### Get Jumlah Kendaraan By Tipe Kendaraan
GET {{kendaraan_url}}/jumlahByTipe?tipe={{tipe}} HTTP/1.1

### Kendaraan Masuk (Add Kendaraan)
POST {{kendaraan_url}}/add HTTP/1.1
Content-Type: application/json

{
  "kendaraan":{
    "tipe":"SUV",
    "platNomor":"B 113 QW",
    "warna":"Hitam",
    "parkiLot":{"id":5 }
  }
}

### Get All data Parkir yang Available = true
GET {{parkir_url}}/all HTTP/1.1

### Add Slot Parkir
POST {{parkir_url}}/add HTTP/1.1
Content-Type: application/json

{
  "nama":"A12"
}

```

---

Note : semua perintah dan keterangan dapat dilihat di resource => Request.http

Thanks from:
Eko Sutrisno
