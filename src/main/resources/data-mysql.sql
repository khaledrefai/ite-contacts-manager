INSERT INTO `contacts`.`company` (`company_id`, `company_name`) VALUES ('1', 'MOHE');
INSERT INTO `contacts`.`branch` (`branch_id`, `branch_name`, `company_company_id`) VALUES ('1', 'Damascus University', '1');
INSERT INTO `contacts`.`department` (`department_id`, `department_name`, `branch_branch_id`) VALUES ('1', 'Networking', '1');
INSERT INTO `contacts`.`users` (`id`, `department_id`, `password`, `role`, `username`, `department_department_id`,`active`) VALUES ('1', '1', 'jamous', 'ADMIN', 'neveen', '1',true);
INSERT INTO `contacts`.`users` (`id`, `department_id`, `password`, `role`, `username`, `department_department_id`,`active`) VALUES ('2', '1', 'caro', 'USER', 'caro', '1',true);
