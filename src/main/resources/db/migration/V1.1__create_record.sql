INSERT INTO users (id, email, first_name, last_name, password, role, status) VALUES
                                                      (1, 'Ilya@gmail.com','Ilya', 'Oshlakov','$2a$12$vBDGQBF8AdWPafc4t0RndOK.uoSV5RDyDqMeep8J0jfv.4qVTnXzW', 'ADMIN', 'ACTIVE'),
                                                      (2, 'Alina@gmail.com', 'Alina', 'Oshlakova', '$2a$12$dJD8rWgmo3qhhCvbKQ6s4ejm2eO8UME/P7eovUiyy9H78wxIUREDy', 'USER', 'ACTIVE');
INSERT INTO tasks (title, description, user_id) VALUES
                                               ('Task1', 'abra cadabra', 1),
                                               ('Task2', 'abra  cadabra', 2);