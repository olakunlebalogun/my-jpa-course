# my-jpa-course

Data Type Association
PK is always BIGINT
N:B when referring to anything associated with database in your entity use under_score NOT hypen.

s/n		Java Class                             MySQL Database
1.              String 					varchar(255)
2. 		Long, short(As long as they are PK)	BIGINT
3.		Integer					INT
4. 		Double 					Double
5. 		Boolean					BIT(1)
6.		Float					FLOAT






// Where account type is merchant


The Annotation
@Entity - this is to tell the spring app context that this will have db representation
@Id - to specify the Primary Key in the database
@Table - to name the table name in the db
@Column
@Lob --- this help to store strings of character long than the default lenght of JPA(255) hence Large OBject(LOB) 
@SequenceGenerator
@GeneratedValue --- this is the Auto-incremnet mechanism, default value is AUTO, other value are IDENTITY, TABLE, SEQUENCE
@AttributeOverride
@AttributeOverrides
@UniqueConstraint

@NotEmpty
@OrderBy
@Digits
@DateTimeFormat


Entity Relationships

OneToMany
This simply mean a child table references a parent table, or in MySQL terms the child table has a foreign key that is pointing to the parent primary key

To implement that, in the parent class declare a list/set of the child, give it @OneToMany annotation with attributes of mappedBy=atrribute_of_child and cascadeType of what suit your suitation check here to understand cascadeType
  
However on the child class, declare an atrribute of parent, annotate with ManyToOne, if you need to change the name of the join column in the child class(that is the column that jioned the parent class) use @JoinColum(name="specify_column_name");




One to One
Let's say the relationship is between class A and class B
This is done by creating an atrribute of class A in class B and annotate it with @OneToOne and define the cascade based on what you want and do the same thing for class B. The result will created a foreign key in both table in the database with links to the other table.


ManyToMany

THis is a Mapping that has the list of the eachother's entity in them, this is the mapping List can be either Set or List, that is based on preference... to do that, declare an attribute of Set or List of the opposite class in the other, annotate with @ManyToMany, on one of the classes adding the mappedBy property which value would be the name of its referenced attribute while on the other use the @JoinTable attribute with property JoinColumn with value @JoinColumn and InverseJoinColumn with value @JoinColumn ... This will create a join table with the @JoinTable name... failing to add the attributes, each tables will have their respective Join tables.







