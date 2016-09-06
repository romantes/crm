INSERT INTO language (id, name, code, deleted) VALUES (1, 'Українська', 'UA', false);
INSERT INTO language (id, name, code, deleted) VALUES (2, 'Русский', 'RU', false);
INSERT INTO language (id, name, code, deleted) VALUES (3, 'English', 'EN', false);

INSERT INTO "user" (name, email, password, is_admin, phone, mobile_phone, note, deleted, image, url, language_id) VALUES ('Геннадий Петров', 'petrov@adiddas.com.ua', '456', false, '(044) 466-45-46', '+380974563232', 'some note', false, NULL, 'http://www.someurl.com/someurl', 2);
INSERT INTO "user" (name, email, password, is_admin, phone, mobile_phone, note, deleted, image, url, language_id) VALUES ('Админис Тратор', 'admin@adiddas.com.ua', '555', true, '+380441234321', '+380970012332', 'first note', false, NULL, 'http://www.adiddas.com.ua/contacts/admin', 1);
INSERT INTO "user" (name, email, password, is_admin, phone, mobile_phone, note, deleted, image, url, language_id) VALUES ('Иван Иванов', 'ivan@unknown.net', '111', true, '+380443333333', '+380973333333', 'this note belongs Ivan', false, NULL, 'http://www.unknown.net', 3);
INSERT INTO "user" (name, email, password, is_admin, phone, mobile_phone, note, deleted, image, url, language_id) VALUES ('Веселов Никифор Иевич', 'taras@i.com', '111', false, NULL, NULL, NULL, false, NULL, NULL, 2);


INSERT INTO company (name, phone, email, address, responsible_user_id, web, deleted, created_by_id, date_create) VALUES ('Adiddas LTD', '(044)5888-52-85', 'adiddas@adiddas.com.ua', 'Киев, ул. Малышка, 1', 1, 'http://www.adiddas.com.ua', false, 1, '2015-02-18 15:36:38');
INSERT INTO company (name, phone, email, address, responsible_user_id, web, deleted, created_by_id, date_create) VALUES ('Le Staro', '+380111111111', 'info@lestaro.com.tw', 'Somewhere in Asia, 1', 1, 'http://www.lestaro.com.tw', false, 2, '2015-08-11 05:22:12');
INSERT INTO company (name, phone, email, address, responsible_user_id, web, deleted, created_by_id, date_create) VALUES ('OOO Джава Велосипед', '111222222', 'lala@i.com', 'address', 2, 'www.java.com', false, 1, '2016-08-30 11:42:54.72');

INSERT INTO contact (name, responsible_user_id, "position", type_of_phone, company_id, phone, skype, email, deleted, date_create, created_by_id) VALUES ('Володимир Грицків', 1, 'junior java developer', 1, 1, '+380505656545', 'gryts.vol', 'some@ukr.net', false, '2015-12-16 20:38:40', 1);
INSERT INTO contact (name, responsible_user_id, "position", type_of_phone, company_id, phone, skype, email, deleted, date_create, created_by_id) VALUES ('Майкл Щур', 1, 'director', 1, 1, '+380505585957', 'michael.shur', 'michael@ukr.net', false, '2016-02-16 15:16:44', 1);
INSERT INTO contact (name, responsible_user_id, "position", type_of_phone, company_id, phone, skype, email, deleted, date_create, created_by_id) VALUES ('Просто Герасим', 3, 'sales manager', 3, 2, '+380503333333', 'skayp-gerasima', 'geras@idiotov.net', false, '2016-01-02 09:00:00', 2);
INSERT INTO contact (name, responsible_user_id, "position", type_of_phone, company_id, phone, skype, email, deleted, date_create, created_by_id) VALUES ('Просто Герасим', 3, 'sales manager', 3, 2, '+380503333333', 'skayp-gerasima', 'geras@idiotov.net', false, '2016-08-30 11:42:54.732', 2);


INSERT INTO stage_deals (id, name, deleted) VALUES (1, 'Первичный контакт', false);
INSERT INTO stage_deals (id, name, deleted) VALUES (2, 'Переговоры', false);
INSERT INTO stage_deals (id, name, deleted) VALUES (3, 'Принимают решение', false);
INSERT INTO stage_deals (id, name, deleted) VALUES (4, 'Согласование договора', false);


INSERT INTO deal (name, stage_id, responsible_user_id, amount, company_id, deleted, date_create, created_by_id, primary_contact_id) VALUES ('small deal', 3, 1, 2500.25, 1, false, '2016-02-11 10:26:44', 1, NULL);
INSERT INTO deal (name, stage_id, responsible_user_id, amount, company_id, deleted, date_create, created_by_id, primary_contact_id) VALUES ('deal-2 (крепеж 2 палеты)', 2, 3, 15330.00, 2, false, '2016-03-11 00:00:40', 3, NULL);
INSERT INTO deal (name, stage_id, responsible_user_id, amount, company_id, deleted, date_create, created_by_id, primary_contact_id) VALUES ('big deal', 1, 1, 12500.00, 1, false, '2016-02-11 10:26:44', 1, NULL);

INSERT INTO attached_file (created_by_id, date_create, filename, filesize, deleted, url_file, file, contact_id, company_id, deal_id) VALUES (1, '2016-02-11 10:36:44', 'document.png', 156882, false, './files/1/document.png', NULL, NULL, 1, NULL);



-- ALTER SEQUENCE "attached_file_id_seq" RESTART WITH 59;

-- ALTER SEQUENCE "company_id_seq" RESTART WITH 84;

INSERT INTO tag (name, deleted) VALUES ('#general-01', false);
INSERT INTO tag (name, deleted) VALUES ('#general-02', false);
INSERT INTO tag (name, deleted) VALUES ('#special-01', false);
INSERT INTO tag (name, deleted) VALUES ('#java', false);

INSERT INTO contact_company_tag (contact_id, tag_id, company_id, deleted) VALUES (1, 3, NULL, false);
INSERT INTO contact_company_tag (contact_id, tag_id, company_id, deleted) VALUES (NULL, 2, 3, NULL);

-- ALTER SEQUENCE "contact_company_tag_id_seq" RESTART WITH 2;

-- ALTER SEQUENCE  "contact_id_seq" RESTART WITH 69;

INSERT INTO currency (id, name, active, deleted) VALUES (1, 'грн', true, false);
INSERT INTO currency (id, name, active, deleted) VALUES (2, 'usd', true, false);
INSERT INTO currency (id, name, active, deleted) VALUES (3, 'euro', false, false);

INSERT INTO deal_contact (deal_id, contact_id) VALUES (1, 1);
INSERT INTO deal_contact (deal_id, contact_id) VALUES (1, 2);

-- ALTER SEQUENCE "deal_id_seq" RESTART WITH 54;

INSERT INTO note (note, created_by_id, date_create, deleted, deal_id, company_id, contact_id) VALUES ('some note some some note', 1, '2016-02-11 10:26:44', false, 1, NULL, NULL);
INSERT INTO note (note, created_by_id, date_create, deleted, deal_id, company_id, contact_id) VALUES ('some second note about the same', 1, '2016-02-15 11:46:42', false, NULL, 1, NULL);
INSERT INTO note (note, created_by_id, date_create, deleted, deal_id, company_id, contact_id) VALUES ('some third note about the some other', 1, '2016-03-15 12:16:01', false, NULL, NULL, 1);
INSERT INTO note (note, created_by_id, date_create, deleted, deal_id, company_id, contact_id) VALUES ('ppppp', 1, '2016-08-30 11:42:54.718', false, NULL, 3, NULL);

-- ALTER SEQUENCE "note_id_seq" RESTART WITH 53;

INSERT INTO rights (user_id, subject_type, subject_type_create, subject_type_read, subject_type_delete, subject_type_change, subject_type_export, deleted) VALUES (1, 0, true, true, false, true, false, false);
INSERT INTO rights (user_id, subject_type, subject_type_create, subject_type_read, subject_type_delete, subject_type_change, subject_type_export, deleted) VALUES (2, 0, true, true, false, true, true, false);
INSERT INTO rights (user_id, subject_type, subject_type_create, subject_type_read, subject_type_delete, subject_type_change, subject_type_export, deleted) VALUES (3, 0, true, false, true, false, true, false);
INSERT INTO rights (user_id, subject_type, subject_type_create, subject_type_read, subject_type_delete, subject_type_change, subject_type_export, deleted) VALUES (1, 1, true, true, true, true, true, false);
INSERT INTO rights (user_id, subject_type, subject_type_create, subject_type_read, subject_type_delete, subject_type_change, subject_type_export, deleted) VALUES (2, 1, false, true, true, false, false, false);
INSERT INTO rights (user_id, subject_type, subject_type_create, subject_type_read, subject_type_delete, subject_type_change, subject_type_export, deleted) VALUES (3, 1, true, true, true, true, true, false);
INSERT INTO rights (user_id, subject_type, subject_type_create, subject_type_read, subject_type_delete, subject_type_change, subject_type_export, deleted) VALUES (1, 2, true, true, true, true, true, false);
INSERT INTO rights (user_id, subject_type, subject_type_create, subject_type_read, subject_type_delete, subject_type_change, subject_type_export, deleted) VALUES (2, 2, false, true, false, true, true, false);
INSERT INTO rights (user_id, subject_type, subject_type_create, subject_type_read, subject_type_delete, subject_type_change, subject_type_export, deleted) VALUES (3, 2, false, true, true, true, true, false);

-- ALTER SEQUENCE  "rights_id_seq" RESTART WITH 77;

-- ALTER SEQUENCE  "tag_id_seq" RESTART WITH 68;

INSERT INTO task_status (id, name, deleted) VALUES (1, 'В работе', false);
INSERT INTO task_status (id, name, deleted) VALUES (2, 'Выполнено', false);
INSERT INTO task_status (id, name, deleted) VALUES (3, 'Приостановлено', false);
INSERT INTO task_status (id, name, deleted) VALUES (4, '1', false);

INSERT INTO task_type (id, name, deleted) VALUES (1, 'Важно', false);
INSERT INTO task_type (id, name, deleted) VALUES (2, 'Срочно', false);
INSERT INTO task_type (id, name, deleted) VALUES (3, 'Работка', false);
INSERT INTO task_type (id, name, deleted) VALUES (4, '1', false);

INSERT INTO task (period, responsible_user_id, task_type_id, created_by_id, name, status_id, deleted, date_create, company_id, contact_id, deal_id, date_task, time_task) VALUES (2, 1, 2, 1, 'Выяснить ситуацию', 2, false, '2016-02-11 10:26:44', 1, NULL, NULL, NULL, NULL);
INSERT INTO task (period, responsible_user_id, task_type_id, created_by_id, name, status_id, deleted, date_create, company_id, contact_id, deal_id, date_task, time_task) VALUES (3, 2, 1, 2, 'Выяснить ситуацию тоже', 1, false, '2016-02-11 10:26:44', NULL, 1, NULL, NULL, NULL);
INSERT INTO task (period, responsible_user_id, task_type_id, created_by_id, name, status_id, deleted, date_create, company_id, contact_id, deal_id, date_task, time_task) VALUES (4, 1, 3, 1, 'Выяснить и эту ситуацию', 1, false, '2016-02-11 10:26:44', NULL, NULL, 1, NULL, NULL);
INSERT INTO task (period, responsible_user_id, task_type_id, created_by_id, name, status_id, deleted, date_create, company_id, contact_id, deal_id, date_task, time_task) VALUES (0, 2, 4, 1, NULL, 4, false, '2016-08-30 11:42:54.706', 3, 2, NULL, NULL, 'Весь день');


-- ALTER SEQUENCE "task_id_seq" RESTART WITH 52;

-- ALTER SEQUENCE "user_id_seq" RESTART WITH 54;

INSERT INTO visit_history (user_id, date_create, ip_address, browser, deleted) VALUES (1, '2016-02-11 10:26:44', '192.168.0.100', 'Mozilla/5.0 (Windows NT 6.3; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/48.0.2564.116 Safari/537.36 OPR/35.0.2066.92', false);
INSERT INTO visit_history (user_id, date_create, ip_address, browser, deleted) VALUES (1, '2016-02-11 10:28:44', '192.168.0.102', 'Mozilla/5.0 (Windows NT 6.3; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/48.0.2564.116 Safari/537.36 OPR/35.0.2066.92', false);


-- SELECT pg_catalog.setval('visit_history_id_seq', 48, true);
-- ALTER SEQUENCE "visit_history_id_seq" RESTART WITH 48;
