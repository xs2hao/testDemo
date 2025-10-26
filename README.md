# testDemo
my Java test demo

SELECT 
    *
FROM
    new_schema.student;
INSERT INTO `new_schema`.`student` (`name`, `age`, `gender`) VALUES ('张伟', 12, 2);
DELETE from `new_schema`.`student` WHERE (`id` = 5);
update `new_schema`.`student` set `name` = '王八' where (`id` = 2);
SELECT * FROM new_schema.student where (`id` = 3);

SELECT `name`, `age`, `gender` FROM student WHERE id = 2;
SELECT * FROM student WHERE id = 2;

SELECT * FROM `new_schema`.`student` WHERE `id` = 2;
SELECT * FROM `new_schema`.`student` WHERE `id` = 3;

use new_schema;
select * from new_schema.student;
ALTER TABLE `new_schema`.`student` ADD COLUMN class_name VARCHAR(50);
INSERT INTO `new_schema`.`student` (`id`, `name`, `age`, `gender`) VALUES (3, '张伟', 12, 2);
INSERT INTO student (`name`, `age`, `gender`, `class_name`) VALUES ('王二蛮子', 12, 2, '高一一班');
update `new_schema`.`student` set `id` = 5 where (`id` = 6);

UPDATE student SET class_name = '计算机科学与技术1班' WHERE id = 1;
UPDATE student SET class_name = '软件工程2班' WHERE id = 2;
UPDATE student SET class_name = '数据科学3班' WHERE id = 3;
UPDATE student SET class_name = '人工智能4班' WHERE id = 4;
