mvn -Dmaven.test.failure.ignore=true  -Dcobertura.report.format=xml  clean  cobertura:cobertura sonar:sonar

rem mvn -Dmaven.test.failure.ignore=true clean  cobertura:cobertura -Dcobertura.report.format=xml sonar:sonar
 
rem mvn -Dmaven.test.skip clean compile  cobertura:cobertura -Dcobertura.report.format=xml   install  sonar:sonar