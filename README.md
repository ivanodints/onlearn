OnLearn

MVP Проекта платформы для онлайн обучения

-= Для локального подключения =-
При первом запуске в MySQL будет создана схема. И при работе с админкой придётся добавить пользователя.

К примеру 

INSERT INTO `onlearn_db`.`web_role` (`id`, `title`) VALUES ('1', 'ROLE_SUPER-ADMIN');

INSERT INTO `onlearn_db`.`user` (`id`, `login`, `password`) VALUES ('1', 'super', '$2a$10$/S3R4zqqVFgWigU.qtniXOYG0Imyu8ON6GlEg3gfkVVCPQM54B2wG');

INSERT INTO `onlearn_db`.`user_roles` (`user_id`, `role_id`) VALUES ('1', '1');

После этого вы сможите занятся наполнением портала.

Или же воспользоватся дампом БД. Который расположен в модуле onlearn-database, в разделе ресурсов.
Если вы используете дамп, то для входа под супер пользователем используйте в качестве логина superadmin и пароль superadmin.

Так же со стороны UI модуля, вы сможите войти под тестовым студентом с логином student и паролем student.
