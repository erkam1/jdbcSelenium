Feature: US1001 kullanici dogru bilgilerle databaseye bagalanabilmeli


  @db
  Scenario: TC01 Kullanici database bilgilerini okur
    Given kullanici HMC veri tabanina baglanir
    And kullanici "tHOTELROOM" tablosundaki "Price" verilerini alır
    And kullanici "Price" stunundaki verileri okur
