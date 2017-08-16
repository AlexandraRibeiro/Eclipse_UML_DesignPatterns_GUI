# @Author: aribeiro
# @Date:   2017-07-17T23:38:12+02:00
# @Email:  aribeiro@student.42.fr
# @Last modified by:   aribeiro
# @Last modified time: 2017-07-18T00:37:52+02:00

echo "********* Compilation *********"
javac -d . -cp avaj_launcher src/avaj_launcher/*.java
echo "*******************************"

echo "____________________________________________________________________________"
echo "java avaj_launcher.Main //pas d'arguments"
java avaj_launcher.Main
echo
echo "____________________________________________________________________________"
echo "java avaj_launcher.Main scenario-aircraftLanded.txt //aircraft landed"
java avaj_launcher.Main scenario-aircraftLanded.txt
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
echo "java avaj_launcher.Main scenario-cycle256.txt //cycle max"
java avaj_launcher.Main scenario-cycle256.txt
echo
echo "____________________________________________________________________________"
echo "java avaj_launcher.Main scenario-cycleneg.txt //cylce negatif"
java avaj_launcher.Main scenario-cycleneg.txt
echo
echo "____________________________________________________________________________"
echo "java avaj_launcher.Main scenario-doubleID.txt //double ID"
java avaj_launcher.Main scenario-doubleID.txt
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
echo "java avaj_launcher.Main scenario-errorregex.txt //error regex"
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
echo "java avaj_launcher.Main scenario-nocycle.txt //one empty line"
java avaj_launcher.Main scenario-oneemptyline.txt
echo
echo "____________________________________________________________________________"
echo "java avaj_launcher.Main scenario-nocycle.tx //fichier inconnu"
java avaj_launcher.Main scenario-nocycle.tx
echo
echo "____________________________________________________________________________"
echo "java avaj_launcher.Main scenario.txt -g // creation md5 valide"
java avaj_launcher.Main scenario.txt -g
echo
echo "____________________________________________________________________________"
echo "java avaj_launcher.Main scenario_MD5.txt // lecture MD5"
java avaj_launcher.Main scenario_MD5.txt
echo
echo "____________________________________________________________________________"
echo "java avaj_launcher.Main scenario_MD5.txt -g // creation md5 erreur fichier"
java avaj_launcher.Main scenario_MD5.txt -g
echo
echo "____________________________________________________________________________"
echo "java avaj_launcher.Main -G // appel generator"
java avaj_launcher.Main -G
echo


