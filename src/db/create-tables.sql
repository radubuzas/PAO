CREATE TABLE Person (
                        id INT AUTO_INCREMENT PRIMARY KEY,
                        CNP VARCHAR(13) NOT NULL,
                        name VARCHAR(255) NOT NULL,
                        dateOfBirth INT NOT NULL,
                        phoneNumber VARCHAR(20),
                        email VARCHAR(255) NOT NULL,
                        username VARCHAR(255),
                        password VARCHAR(255)
);

CREATE TABLE Subject (
                         id INT AUTO_INCREMENT PRIMARY KEY,
                         name VARCHAR(255) NOT NULL
);

CREATE TABLE Subject_Teacher (
                                 subject_id INT,
                                 teacher_id INT,
                                 FOREIGN KEY (subject_id) REFERENCES Subject(id),
                                 FOREIGN KEY (teacher_id) REFERENCES Person(id),
                                 PRIMARY KEY (subject_id, teacher_id)
);

CREATE TABLE Subject_Student (
                                 subject_id INT,
                                 student_id INT,
                                 FOREIGN KEY (subject_id) REFERENCES Subject(id),
                                 FOREIGN KEY (student_id) REFERENCES Person(id),
                                 PRIMARY KEY (subject_id, student_id)
);

INSERT INTO Person (CNP, name, dateOfBirth, phoneNumber, email, username, password)
VALUES ('1234567890123', 'John Doe', UNIX_TIMESTAMP('1980-01-01'), '+1234567890', 'john.doe@example.com', 'johndoe', 'password123');

INSERT INTO Person (CNP, name, dateOfBirth, phoneNumber, email, username, password)
VALUES ('9876543210987', 'Jane Smith', UNIX_TIMESTAMP('1990-05-15'), '+0987654321', 'jane.smith@example.com', 'janesmith', 'password456');

INSERT INTO Subject (name)
VALUES ('Mathematics');

INSERT INTO Subject (name)
VALUES ('English');

INSERT INTO Subject_Teacher (subject_id, teacher_id)
VALUES (1, 1);

INSERT INTO Subject_Teacher (subject_id, teacher_id)
VALUES (2, 2);

INSERT INTO Subject_Student (subject_id, student_id)
VALUES (1, 2);