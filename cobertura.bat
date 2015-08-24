rem mvn clean  install
mvn -Dmaven.test.failure.ignore=true clean compile  cobertura:cobertura -Dcobertura.report.format=xml   install  sonar:sonar
 
rem mvn -Dmaven.test.skip clean compile  cobertura:cobertura -Dcobertura.report.format=xml   install  sonar:sonar