LIST_COURSES {
     SELECT * FROM course;
}

ADD_COURSE {
    INSERT INTO course (code, title, credits) VALUES (?, ?, ?);
}

