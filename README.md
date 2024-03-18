Assignment3 Q1 Comp3005

Rhys Martin 101220597

To setup:

Change the jdbcUrl in the code to match the one you are currently using.

To setup the database table:

CREATE TABLE students ( student_id SERIAL PRIMARY KEY, first_name TEXT NOT NULL, last_name TEXT NOT NULL, email TEXT NOT NULL UNIQUE, enrollment_date DATE );

INSERT INTO students (first_name, last_name, email, enrollment_date) VALUES ('John', 'Doe', 'john.doe@example.com', '2023-09-01'), ('Jane', 'Smith', 'jane.smith@example.com', '2023-09-01'), ('Jim', 'Beam', 'jim.beam@example.com', '2023-09-02');

Paste this in the SQL query of PostgreSQL

Run the code!

Here is a video of it running!

https://youtu.be/5_kWi73-ZbU
