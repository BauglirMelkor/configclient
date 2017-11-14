# configclient

Ayağa kalktığında config server'la iletişime geçer ve kendisine sağlanan application.properties dosyasını okur.
Embedded Mongo db üzerinde kendisine atanan yeni property'leri saklar
8080 potu üzerinde çalışır.

Rest Apiler

http://localhost:8080/siteName

http://localhost:8080/isBasketEnabled

http://localhost:8080/maxItemCount

http://localhost:8080/save/{siteName}/{isBasketEnabled}/{maxItemCount}/{applicationName}

http://localhost:8080/find/{applicationName}
