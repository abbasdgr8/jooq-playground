/**
 * Author:  Abbas Attarwala <abbas@muon-c.com>
 * Created: 5 Aug 2022
 */
DROP TABLE IF EXISTS COUNTRIES;

CREATE TABLE COUNTRIES (
    id INT AUTO_INCREMENT PRIMARY KEY, 
    country_name VARCHAR(250) NOT NULL
)