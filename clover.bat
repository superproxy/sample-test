rem mvn clean  install
mvn clean clover2:setup test clover2:aggregate clover2:clover
mvn sonar:sonar