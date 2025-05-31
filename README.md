🛴 Проект: UI-тесты для сервиса аренды самокатов

Тестовый проект для проверки пользовательского интерфейса учебного сайта qa-scooter.praktikum-services.ru, реализованный с использованием Selenium WebDriver.

⸻

🚀 Используемые технологии

Технология	Версия
Java	11
Maven	3.9.0
JUnit	4.13.2
Selenium	3.141.59
ChromeDriver	136.0


⸻

⚙️ Настройка проекта
1.	Клонируй репозиторий:

git clone https://github.com/goroguz/Sprint_4.git


	2.	Убедись, что установлен:
	•	JDK 11+
	•	Maven
	•	Chrome + подходящий ChromeDriver
	3.	Пропиши путь к chromedriver (если используешь вручную):

System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

Если используешь WebDriverManager, прописывать путь не нужно.

⸻

▶️ Как запустить тесты

mvn clean test

Все тесты запускаются с использованием JUnit4.

⸻

📁 Структура проекта
```
src
└── test
    └── java
        └── com.yandex.scooter.constants (Helper classes)
        └── com.yandex.scooter.test (Test classes)
        └── com.yandex.scooter.pom (PageObjects)

```

⸻

📌 Особенности
-	Параметризованные тесты реализованы через @RunWith(Parameterized.class)
-	Локаторы вынесены в Page Object классы
-	Реализовано покрытие всех вопросов FAQ и позитивный флоу заказа