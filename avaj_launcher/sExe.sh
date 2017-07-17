# @Author: aribeiro
# @Date:   2017-07-17T23:38:12+02:00
# @Email:  aribeiro@student.42.fr
# @Last modified by:   aribeiro
# @Last modified time: 2017-07-17T23:55:16+02:00

echo "********* Compilation *********"
javac -d . -cp avaj_launcher src/avaj_launcher/*.java
echo "*******************************"

echo "____________________________________________________________________________"
echo "java avaj_launcher.Main //pas d'arguments"
java avaj_launcher.Main
echo
echo "____________________________________________________________________________"
echo "java avaj_launcher.Main scenario-cycle0.txt //cycle == 0"
java avaj_launcher.Main scenario-cycle0.txt
echo
echo "____________________________________________________________________________"
echo "java avaj_launcher.Main scenario-cyclealpha.txt //cycle == A"
java avaj_launcher.Main scenario-cyclealpha.txt
echo
echo "____________________________________________________________________________"
echo "java avaj_launcher.Main scenario-cycle256.txt // cycle max"
java avaj_launcher.Main scenario-cycle256.txt
echo
echo "java avaj_launcher.Main scenario-cycleneg.txt // cylce negatif"
java avaj_launcher.Main scenario-cycleneg.txt
echo
echo "____________________________________________________________________________"
echo "java avaj_launcher.Main scenario-empty.txt //empty file"
java avaj_launcher.Main scenario-empty.txt
echo
echo "____________________________________________________________________________"
echo "java avaj_launcher.Main scenario-errorID.txt //error ID"
java avaj_launcher.Main scenario-errorID.txt
echo
echo "____________________________________________________________________________"
echo "java avaj_launcher.Main scenario-errorregex.txt // error regex"
java avaj_launcher.Main scenario-errorregex.txt
echo
echo "____________________________________________________________________________"
echo "java avaj_launcher.Main scenario-errortype.txt //error de type"
java avaj_launcher.Main scenario-errortype.txt
echo
echo "____________________________________________________________________________"
echo "java avaj_launcher.Main scenario-nocycle.txt //pas de lignes avec le cycle"
java avaj_launcher.Main scenario-nocycle.txt
echo
echo "____________________________________________________________________________"
echo "java avaj_launcher.Main scenario-nocycle.tx //pas de cycle"
java avaj_launcher.Main scenario-nocycle.tx
