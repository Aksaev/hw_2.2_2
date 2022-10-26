package transport;

import java.time.LocalDate;

public class Car {

    private String brand;
    private String model;
    private double engineVolume;
    private String color;
    private int productionYear;
    private String productionCountry;

    private String gearBox;
    private final String bodyType;
    private String regNumber;
    private final int placesCount;
    private boolean winterTires;

    private final Key key;
    private final Insurance insurance;


    public Car(String brand,
               String model,
               double engineVolume,
               String color,
               int productionYear,
               String productionCountry,
               String gearBox,
               String bodyType,
               String regNumber,
               int placesCount,
               boolean winterTires,
               Key key,
               Insurance insurance) {

        this.brand = ValidationUtils.validOrDefault(brand, "[ default ]");
        this.model = ValidationUtils.validOrDefault(model, "[ default ]");
        this.productionYear = productionYear >=0 ? productionYear : 2000;
        this.productionCountry = ValidationUtils.validOrDefault(productionCountry, "Россия");
        this.bodyType = ValidationUtils.validOrDefault(model, "[ default ]");
        this.placesCount = Math.max(placesCount, 1);
        this.key = key;
        this.insurance = insurance;

        setEngineVolume(engineVolume);
        setColor(color);
        setGearBox(gearBox);
        setRegNumber(regNumber);
        setWinterTires(winterTires);
    }

    // Установка сезона шин
    public void setSeasonTires() {
        int currentMonth = LocalDate.now().getMonthValue();
        this.winterTires = currentMonth <= 4 || currentMonth >= 11;
    }

    // Проверка номера машины на валидность
    public boolean isRegNumberValid() {
        if (this.regNumber.length() != 9) {
            return false;
        }
        char[] regNumberChars = this.regNumber.toCharArray();
        return isNumberLetter(regNumberChars[0])
                && isNumber(regNumberChars[1])
                && isNumber(regNumberChars[2])
                && isNumber(regNumberChars[3])
                && isNumberLetter(regNumberChars[4])
                && isNumberLetter(regNumberChars[5])
                && isNumber(regNumberChars[6])
                && isNumber(regNumberChars[7])
                && isNumber(regNumberChars[8]);
    }
    // Проверка, является ли переданный символ - цифрой
    private boolean isNumber(char symbol) {
        return Character.isDigit(symbol);
    }
    private boolean isNumberLetter(char symbol) {
        String allowedSymbols = "АВЕКМНОРСТУХ";
        return allowedSymbols.contains("" + symbol);
    }
    public String getBrand() {
        return brand;
    }
    public String getModel() {
        return model;
    }
    public double getEngineVolume() {
        return engineVolume;
    }
    public void setEngineVolume(double engineVolume) {
        this.engineVolume = engineVolume > 0.0 ? engineVolume : 1.5;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = ValidationUtils.validOrDefault(color, "Белый");
    }
    public int getProductionYear() {
        return productionYear;
    }
    public String getProductionCountry() {
        return productionCountry;
    }
    public String getGearBox() {
        return gearBox;
    }
    public void setGearBox(String gearBox) {
        this.gearBox = ValidationUtils.validOrDefault(gearBox, "[ default ]");
    }

    public String getBodyType() {
        return bodyType;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public void setRegNumber(String regNumber) {
        this.regNumber = regNumber;
    }

    public int getPlacesCount() {
        return placesCount;
    }

    public boolean isWinterTires() {
        return winterTires;
    }

    public void setWinterTires(boolean winterTires) {
        this.winterTires = winterTires;
    }

    @Override
    public String toString() {
        System.out.println("-----------------------------------------------------------");
        return brand + " " + model + ":\n" +
                "  - Год выпуска: " + productionYear + "\n" +
                "  - Сборка: " + productionCountry + "\n" +
                "  - Цвет кузова: " + color + "\n" +
                "  - Объем двигателя: " + engineVolume + " литра";
    }

    public Key getKey() {
        return key;
    }

    public Insurance getInsurance() {
        return insurance;
    }

    public static class Key {
        private final boolean remoteEngineStart;
        private final boolean keylessAcces;

        public Key(boolean remoteEngineStart, boolean keylessAcces) {
            this.remoteEngineStart = remoteEngineStart;
            this.keylessAcces = keylessAcces;
        }

        public boolean isRemoteEngineStar() {
            return remoteEngineStart;
        }

        public boolean isKeylessAcces() {
            return keylessAcces;
        }

    }

    public static class Insurance {
        private final LocalDate validUntil;
        private final float cost;
        private final String number;

        public Insurance(LocalDate validUntil, float cost, String number) {
            this.validUntil = validUntil != null ? validUntil : LocalDate.now().plusDays(10);
            this.cost = Math.max(cost, 1f);
            this.number = ValidationUtils.validOrDefault(number, "[ default ]");
    }
        public boolean isNumberValid() {
            return number.length() == 9;
        }

        public boolean isInsuranceValid() {
            return LocalDate.now().isBefore(this.validUntil);
        }

    }

}
