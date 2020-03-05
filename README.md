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

---

Note : semua perintah dan keterangan dapat dilihat di resource => Request.http

Thanks from:
Eko Sutrisno
