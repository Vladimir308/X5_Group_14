# Проект по автоматизации тестовых сценариев для <a href="https://www.x5.ru/ru"> X5_Group</a></h1>

****

## ☑️ Содержание:

- Использованные технологии и инструменты
    - Список реализованных тестов
    - Содержание Allure Report
- Запуск автотестов
    - Запуск тестов из терминала
    - Запуск тестов на удаленном браузере
    - Параметры сборки
    - Интеграция с Allure TestOps
    - Уведомление в Telegram
    - Демо видео запуска тестов

****

## ☑️ Использованные технологии и инструменты
<p align="center">
<a href="https://www.jetbrains.com/idea/"><img width="7%" title="IntelliJ IDEA" src="media/logo/IntelliJ_IDEA.png"></a>
<a href="https://www.java.com/"><img width="7%" title="Java" src="media/logo/Java.png"></a>
<a href="https://gradle.org/"><img width="7%" title="Gradle" src="media/logo/Gradle.png"></a>
<a href="https://junit.org/junit5/"><img width="7%" title="JUnit5" src="media/logo/JUnit5.png"></a>
<a href="https://selenide.org/"><img width="7%" title="Selenide" src="media/logo/Selenide.png"></a>
<a href="https://www.jenkins.io/"><img width="7%" title="Jenkins" src="media/logo/Jenkins.png"></a>
<a href="https://aerokube.com/selenoid/"><img width="7%" title="Selenoid" src="media/logo/Selenoid.png"></a>
<a href="https://allurereport.org/"><img width="7%" title="Allure Report" src="media/logo/AllureReports.png"></a>
<a href="https://qameta.io/"><img width="7%" title="Allure TestOps" src="media/logo/AllureTestOps.svg"></a>
<a href="https://github.com/"><img width="7%" title="GitHub" src="media/logo/GitHub.png"></a>
<a href="https://web.telegram.org/k/"><img width="7%" title="Telegram" src="media/logo/Telegram.png"></a>
</p>

- В данном проекте автотесты написаны на языке <code>Java</code> с использованием фреймворка для тестирования <code>
  Selenide</code>.
- В качестве сборщика был выбран - <code>Gradle</code>.
- Использован фреймворк модульного тестирования <code>JUnit 5</code>.
- При прогоне тестов запуск браузера происходит в <code>Selenoid</code>.
- Для удаленного запуска реализована джоба в <code>Jenkins</code> с формированием <code>Allure Report</code>.
- После завершения сборки, бот созданный в <code>Telegram</code>, автоматически обрабатывает и отправляет сообщение с
  результатом в специальную группу.
- Осуществлена интеграция с <code>Allure TestOps</code>.

### Список реализованных тестов:

- Проверка переходов на страницы в социальных сетях, адреса и номера телефонов;
- Проверка адреса;
- Проверка номеров телефона;
- Проверка перехода на страницу X5 VK;
- Проверка перехода на страницу TenChat;
- Проверка функционала обратной связи;
- Проверить что в обратной связи при выборе роли поставщика раздел горячая линия переходит на страницу X5Dialog;
- Проверить что в обратной связи при выборе роли жалоба директору по безопасности сообщение успешно отправляется;
- Проверить что в обратной связи при выборе роли покупателя и нажатии далее сообщение успешно отправляется;
- Проверить что в обратной связи при выборе прочие обращения и нажатии далее сообщение успешно отправляется;
- Проверить что в обратной связи при выборе роли сотрудника и нажатии далее открылась страница Обращение на Горячую
  линию;
- Проверка открытия верхнего меню;
- Проверка верхнего меню на разных языках;
- Проверка разделов верхнего меню;
- Проверить что при нажатии на Investors отображается Investor Relations;
- Проверить что при нажатии на Press Centre отображается Press center;
- Проверка поиска;

### Содержание Allure Report:

- Шаги теста;
- Скриншот страницы на последнем шаге;
- Page Source;
- Логи браузерной консоли;
- Видео выполнения автотеста.

****

## ☑️ Запуск автотестов

### Запуск тестов из терминала

```bash
gradle clean Contacts_Test -Denv=local
gradle clean Feed_back_Test -Denv=local
gradle clean Top_Menu_Test -Denv=local
```

### Запуск тестов из терминала на удаленном браузере

```bash
gradle clean Contacts_Test -Denv=remote
gradle clean Feed_back_Test -Denv=remote
gradle clean Top_Menu_Test -Denv=remote
```

### Запуск тестов на удаленном браузере

```bash  
clean
${TASK}
-DbaseUrl=${BASE_URL}
-Dbrowser=${BROWSER}
-DbrowserSize=${BROWSER_SIZE}
-DbrowserVersion=${BROWSER_VERSION}
-DremoteUrl=https://${LOGIN}:${PASSWORD}@${SELENOID_URL}/wd/hub
```

### Параметры сборки:

- REMOTE (адрес удаленного сервера Selenoid)
- BROWSER (браузер, по умолчанию chrome)
- VERSION (версия браузера, по умолчанию 126.0)
- BROWSER_SIZE (размер окна браузера, по умолчанию 1920x1080)
- TASK (набор кейсов для запуска)
- BRANCH (ветка, на которой надо запустить тесты, по умолчанию main)

****

## Сборки:

- <a id="jenkins"></a> <img alt="Jenkins" height="25" src="media/logo/Jenkins.png" width="25"/></a><a name="Сборка"></a>
  Сборка в [Jenkins](https://jenkins.autotests.cloud/job/X5_Group_14/)</a>

- <a id="Allure"></a> <img alt="Allure" height="25" src="media/logo/AllureReports.png" width="25"/></a><a name="Сборка"></a>
  Сборка в [Allure](https://jenkins.autotests.cloud/job/X5_Group_14/allure/)</a>

- <a id="Allure TestOps"></a> <img alt="Allure TestOps" height="25" src="media/logo/AllureTestOps.svg" width="25"/></a><a name="Сборка"></a>
  Сборка в [Allure TestOps](https://allure.autotests.cloud/launch/44233)</a>

****

## ☑️ Визуализация

Ниже представлены скриншоты основных инструментов и процессов, используемых в ходе разработки и тестирования проекта.
<details>
  <summary>Сборка в Jenkins</summary>
<p align="center">
<img width="100%" title="Jenkins" src="media/screenshots/Jenkins.png">
</p>
</details>

<details>
  <summary>Пример Allure Report</summary>

#### Превью

<p align="center">
<img width="100%" title="AllureReportPreview" src="media/screenshots/Allure.png">
</p>

#### Результат выполнения теста

<p align="center">
<img width="100%" title="AllureReport" src="media/screenshots/Allure Report.png"> 
</p>

#### Графики

<p align="center">
<img width="100%" title="AllureReportGraphics" src="media/screenshots/Allure Report Graphics.png.png">
</p>

</details>

<details>
  <summary>Интеграция с Allure TestOps</summary>
<p align="center">
<img width="100%" title="AllureTestOps" src="media/screenshots/TestOps.png">
</p>
</details>

<details>
  <summary>Уведомление в Telegram</summary>
<p align="center">
<img width="60%" title="Telegram" src="media/screenshots/Telegram.png">
</p>
</details>

<details>
  <summary>Демо видео запуска тестов</summary>
<p align="center">
  <img width="80%" title="Selenoid Video" src="media/video/Allure Report.gif">
</p>
</details>

****