## Gerekli Kurulumlar
 > * Java JDK 8 +
 > * Docker
 
 ## Kullanılan Teknolojiler
 > * Java 8
 > * Docker
 > * Maven
 > * Selenium Grid
 > * TestNG
 
 ## Kullanılan Teknolojiler Testin Çalıştırılabilmesi İçin Gerekli Ortam Nasıl Oluşturulur?
* Proje Github'dan clone edilir.
* Docker Deamon başlatışır ve projenin olduğu dizinin içine girilerek `docker-compose up -d` komutu çalıştırılır.
* Bu yml dosyası gerekli altyapıları içindeki image'lar ile kurar.
* `İmage list; selenium-grid-hub,firefox node, chrome node.`
* Bu compose.yml dosyası tek bir firefox ve chrome tarayıcısını hub'a register eder.(her biri farklı iki nod) Eğer scale etmek istoyorsanız compose dosyasını `docker-compose up -d --scale firefox=arg0 --scale chrome=arg1` olarak çalıştırmanız yeterlidir.
* http://localhost:4444/grid/console'e giderek Selenium Grid hub'nın ayakta olduğu ve node'ların register olup olduğu kontrol edilir.

## Terminalden nasıl çalışır?
<pre><code>mvn test -Dsurefire.suiteXmlFiles=src/test/java/Suites/ParallelTestWithBrowsers.xml</code></pre>
