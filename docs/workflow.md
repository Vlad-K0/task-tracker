# Воркфлоу задач спринта task-tracker

> Как задача живёт от карточки на доске до мержа в main. Доска: `~/Projects/AntigravityProject/MyLife/lifeSystem/learning/task-tracker-board.md` (синк в Singularity — оттуда). Источник истины по содержанию этапов — [docs/learning/task-tracker-stages.md](learning/task-tracker-stages.md) (локально, в git не попадает).

## Типы задач и ID

| Префикс | Зона | Этапы курса |
|---|---|---|
| `D` | Инфраструктура: compose, сети, volume, Dockerfile, CI/CD | 1, 9 |
| `TB` | `services/backend` | 2, 3, 5 |
| `TF` | `services/frontend` | 4, 6 |
| `TE` | `services/email-sender` | 7 |
| `TS` | `services/scheduler` | 8 |
| `R` | Репозиторий: доки, .gitignore, сам воркфлоу | — |

- ID: `PFX-N` (`D-1`, `TB-3`). Нумерация сквозная внутри префикса, ID никогда не переиспользуются.
- Новый сервис в `services/` → новый префикс по первой букве имени (конфликты решать второй буквой).

## Форматы

- **Ветка:** `<type>/<TaskID>-<slug>` от актуального main. Типы: `feat`, `fix`, `docs`, `chore`, `test`, `refactor`, `build`, `ci`. Примеры: `feat/D-1-postgres-compose`, `fix/D-2-kafka-network`, `feat/TB-1-user-entity`.
- **Коммит:** `[TaskID] type(scope): тема` — type и scope английские, тема русская, мелкие и осмысленные коммиты (по плейбуку). Пример: `[D-1] feat(compose): postgres + healthcheck + volume`.
- **Merge-commit:** `Merge <branch> [<TaskID>]`.

## Жизненный цикл

1. Карточка на доске получает ID и колонку «В работе».
2. `git checkout main && git pull` (когда появится remote) → `git checkout -b <type>/<TaskID>-<slug>`.
3. Работа: коммиты в формате выше, сверка с чек-листом фазы 1 плейбука.
4. DoD закрыт буква в букку → `git checkout main && git merge --no-ff <branch>` → удалить ветку → карточку в «Сделано».
5. В main попадает только слитое и проверенное; на ветке живёт вся черновая история задачи.

## Как посмотреть одну задачу

- Коммиты задачи: `git log main..<branch>` (пока ветка жива) или `git log <merge-commit>^1..<merge-commit>` (после мержа).
- Границы задач в истории: `git log --graph --oneline` — каждая задача видна «пузырём» от merge-commit.

## Связка с Singularity

Заголовок задачи в Singularity: `[TaskID] заголовок` — в стиле существующих префиксов `[Инфра]`/`[Код]`. Перенос из доски — агентом MyLife по явной просьбе («синкни доску task-tracker»).
