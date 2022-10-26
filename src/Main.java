import transport.Car;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Car car = new Car(
                "Lada",
                "Grande",
                1.7,
                "Желтый",
                2018,
                "Россия",
                "МКПП",
                "Седан",
                "А001МН177",
                4,
                true,
                new Car.Key(true, true),
                new Car.Insurance(LocalDate.now().plusMonths(3), 1000.0f, "123456789")
        );
//        Car audiA8 = new Car("Audi", "A8 50 L TDI quattro", 2020, "Германия", "Черный", 3.0);
//        Car bmwZ8 = new Car("BMW", "Z8", 2021, "Германия", "Черный", 3.0);
//        Car kiaSportage4 = new Car("Kia", "Sportage 4", 2018, "Южная Корея", "Красный", 2.4);
//        Car hyundaiAvante = new Car("Hyundai", "Avante", 2016, "Южная Корея", "Оранжевый", 1.6);

        System.out.println("Урок 2.2 ООП. Домашнее задание - transport.Car.");

        System.out.println(car);
//        System.out.println(audiA8);
//        System.out.println(bmwZ8);
//        System.out.println(kiaSportage4);
//        System.out.println(hyundaiAvante);

        if (!car.getInsurance().isInsuranceValid()) {
            System.out.println("Строховка просрочена!");
        }
    }
}