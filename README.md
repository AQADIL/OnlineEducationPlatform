# Online Education Platform

> Small Java console app that behaves like a tiny LMS: builds courses, plugs in legacy quizzes, recommends what to study next and notifies students when they finish modules.



```text

Flow   : builder → factory → adapter → bridge → strategy → observer
```


## Tech Stack

- **Language:** Java (console)
- **Entry point:** `com.platform.app.Main`
- **Build:** any IDE (IntelliJ / VS Code) or plain `javac`

## Project Structure

```text
src/
└── com/platform/
    ├── app/
    │   └── Main.java                     // Wires everything together
    ├── model/
    │   ├── Course.java                   // Course with modules and quizzes
    │   ├── Module.java                   // Single learning module
    │   ├── LearningContent.java          // Base class for content
    │   ├── Quiz.java                     // Quiz with questions and score
    │   └── Student.java                  // Student profile
    ├── builder/
    │   └── CourseBuilder.java            // Fluent course construction
    ├── factory/
    │   ├── ContentFactory.java           // Creates content by type
    │   ├── VideoContent.java             // Video lesson
    │   ├── TextContent.java              // Text article
    │   └── InteractiveContent.java       // Interactive lab
    ├── adapter/
    │   ├── LegacyQuizSystem.java         // Old quiz API
    │   └── QuizAdapter.java              // Wraps legacy quiz as modern Quiz
    ├── bridge/
    │   ├── PresentationRenderer.java     // Rendering interface
    │   ├── ContentPresentation.java      // High-level course view
    │   ├── ConsoleRenderer.java          // Verbose console layout
    │   ├── MinimalisticRenderer.java     // Compact console layout
    │   ├── DetailedContentPresentation.java // Full course view
    │   └── SummaryContentPresentation.java  // Short course view
    ├── strategy/
    │   ├── RecommendationStrategy.java   // Strategy interface
    │   ├── PopularityBasedStrategy.java  // Sorts by "popularity" (modules count)
    │   ├── DifficultyBasedStrategy.java  // Matches difficulty to student level
    │   └── RecommendationEngine.java     // Uses selected strategy
    └── observer/
        ├── StudentObserver.java          // Listener interface
        ├── NotificationService.java      // Prints notifications to console
        └── LearningProgressTracker.java  // Publishes events
```

## Design Patterns

### 1. Builder – course construction

- **Classes:** `CourseBuilder`, `Course`, `Module`, `Quiz`
- **Idea:** собирать курс по шагам (название, описание, модули, квизы) и получать готовый `Course` через `build()`.
- **В Main:** раздел "1. BUILDER PATTERN" – конструируется курс "Advanced Java Programming" с тремя модулями и квизом.

### 2. Factory – контент по типу

- **Classes:** `ContentFactory`, `VideoContent`, `TextContent`, `InteractiveContent`, `LearningContent`
- **Idea:** по строке типа (`"video"`, `"text"`, `"interactive"`) создаётся нужный класс контента.
- **В Main:** раздел "2. FACTORY PATTERN" – создаётся видео, текст и интерактивный лаб, которые прикрепляются к первому модулю курса.

### 3. Adapter – старый квиз в новой системе

- **Classes:** `LegacyQuizSystem`, `QuizAdapter`, `Quiz`
- **Idea:** обернуть старый интерфейс викторин так, чтобы он выглядел как обычный `Quiz`, без переписывания легаси.
- **В Main:** раздел "3. ADAPTER PATTERN" – квиз `java-basics` превращается в современный `Quiz` и добавляется к курсу.

### 4. Bridge – представление курса

- **Classes:** `ContentPresentation`, `PresentationRenderer`,
  `DetailedContentPresentation`, `SummaryContentPresentation`,
  `ConsoleRenderer`, `MinimalisticRenderer`
- **Idea:** разделить *что* показываем (курс, модули, квизы) и *как* выводим (подробный или минималистичный вид).
- **В Main:** раздел "4. BRIDGE PATTERN" – один и тот же курс показывается в двух разных консольных стилях.

### 5. Strategy – рекомендации по курсам

- **Classes:** `RecommendationStrategy`, `PopularityBasedStrategy`,
  `DifficultyBasedStrategy`, `RecommendationEngine`
- **Idea:** можно подменять алгоритм рекомендаций без изменения кода вызова.
- **В Main:** раздел "5. STRATEGY PATTERN" – сначала рекомендации по популярности, затем – по уровню студента.

### 6. Observer – уведомления студенту

- **Classes:** `StudentObserver`, `LearningProgressTracker`, `NotificationService`
- **Idea:** при завершении модуля или выставлении оценки все подписчики получают уведомление.
- **В Main:** раздел "6. OBSERVER PATTERN" – при завершении модулей и оценке квиза в консоль летят уведомления для текущего студента.

## How to Run

### Через IDE (IntelliJ IDEA / VS Code)

1. Открыть папку проекта как Java-проект.
2. Убедиться, что `src` отмечена как Source Root.
3. Запустить класс `com.platform.app.Main` как Java Application.

### Через терминал (если установлен `javac`)

```bash
javac -d out -sourcepath src src/com/platform/app/Main.java
java -cp out com.platform.app.Main
```

