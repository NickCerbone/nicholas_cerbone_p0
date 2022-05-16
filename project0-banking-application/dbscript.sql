create table user_details (
				user_id INT GENERATED ALWAYS AS IDENTITY,   
				password VARCHAR(25) NOT NULL,  
				PRIMARY KEY(user_id));

create table accnt_details (
				accnt_id INT GENERATED ALWAYS AS IDENTITY,
				user_id INT, 
				balance DOUBLE PRECISION NOT NULL, 
				PRIMARY KEY(accnt_id)
				CONSTRAINT fk_user
					FOREIGN KEY(user_id)
						REFRENCES user_details(user_id));
						
INSERT INTO user_details(password) VALUES ('"+userPojo.getPassword()+"')";