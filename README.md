<h1>Симулятор гонок 🏎️</h1>
<p>
    <strong>ООП ЛАБОРАТОРНАЯ РАБОТА №2</strong> <br>
    Спроектирована классовая модель видов транспорта и реализована симуляция разных видов гонок на <strong>java 17, spring boot 3.2.0</strong> и <strong>Spring Data JPA</strong>.
</p>
<div class="ascii-art">
    <pre>
            &lt;=======]&#125;======        
            --.   /|                        
           _\"/_.'/                       
         .'._._,.'                      
         :/ \{}/                        
         &#40;L  /--',----._     
            |          \\        
           : /-\ .'-'\ / |   
            \\, ||    \|             
             \/ ||    ||
        </pre>
</div>
<h3>Виды Транспорта</h3>
<p>
    Все виды транспорта делятся на две абстракции: <strong>ВОЗДУШНЫЕ</strong> и <strong>НАЗЕМНЫЕ</strong>.
</p>
<p>Наземные виды транспорта имеют следующие характеристики:</p>
<ol>
    <li>Скорость движения (в условных единицах)</li>
    <li>Время движения до необходимого отдыха (в условных единицах)</li>
    <li>Длительность отдыха (условных единицах), зависящая от порядкового номера остановки</li>
</ol>

<p>Воздушные виды транспорта характеризуются:</p>
<ol>
    <li>Скоростью движения (в условных единицах)</li>
    <li>Коэффициентом ускорения (задается формулой, зависит от расстояния)</li>
</ol>

## Установка и запуск

```bash
# Step 1: Clone the repository
git clone git@github.com:rifat-dev/racingSimulator.git

# Step 2: Navigate to the project directory
cd racingSimulator

# Step 3: 
...

# Step *: Access the application
Open browser and go to http://localhost:8080
```

## Структура работы в виде дерева:
```
./src/main/
├── java
│   └── com
│       └── rifat
│           └── racingSimulator
│               ├── DTO
│               │   ├── RaceResultDTO.java
│               │   └── RaceStartDTO.java
│               ├── RacingSimulatorApplication.java
│               ├── config
│               │   └── OpenApiConfig.java
│               ├── controller
│               │   ├── RaceController.java
│               │   ├── VehicleController.java
│               │   └── VehicleControllerView.java
│               ├── model
│               │   ├── AirVehicle.java
│               │   ├── BootsOfSpeedLandVehicle.java
│               │   ├── BroomAirVehicle.java
│               │   ├── CentaurLandVehicle.java
│               │   ├── ChickenLeggedHutLandVehicle.java
│               │   ├── FlyingShipAirVehicle.java
│               │   ├── LandVehicle.java
│               │   ├── MagicCarpetAirVehicle.java
│               │   ├── PumpkinCarriageLandVehicle.java
│               │   ├── Race.java
│               │   ├── RaceParticipantLink.java
│               │   ├── RaceParticipantLinkId.java
│               │   ├── RaceType.java
│               │   ├── StupaOfBabaYagaAirVehicle.java
│               │   └── Vehicle.java
│               ├── repository
│               │   ├── AirVehicleRepository.java
│               │   ├── LandVehicleRepository.java
│               │   ├── RaceParticipantLinkRepository.java
│               │   ├── RaceRepository.java
│               │   └── VehicleRepository.java
│               └── service
│                   ├── RaceService.java
│                   └── VehicleService.java
└── resources
    ├── application.properties
    ├── static
    └── templates
        ├── hello.html
        ├── racing-simulator.html
        └── vehicles.html
```
<p class="note">
    ITMO University<br>
    Saint Petersburg Autumn 2023
</p>

<style>
    body {
        font-family: 'Times New Roman', serif;
        line-height: 1.6;
        max-width: 800px;
        margin: 0 auto;
        padding: 20px;
    }
    h1 {
        text-align: center;
        color: #333;
    }
    p {
        text-indent: 1.5em;
    }
    .ascii-art {
        font-family: 'Courier New', monospace;
        white-space: pre;
    }
    .note {
        text-align: center;
        font-style: italic;
        color: #777;
    }
</style>