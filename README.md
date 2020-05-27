EPS (nombre, ipIPS, ipPropia, puerto)
INS (ipIPS, ipPropia) -> solo hay uno
Cliente (ipIPS, ipPropia, puerto)
INS = 49152
EPS = 49153
IPS = 49154

orden
IPS -> INS -> EPS -> cliente

Ej:
java sIPS
java sINS 127.0.0.1 127.0.0.1
java sEPS Medisalud 127.0.0.1 127.0.0.1 9876
java sEPS "Nueva EPS" 127.0.0.1 127.0.0.1 9875
java sCliente 127.0.0.1 127.0.0.1 2345
java sCliente 127.0.0.1 127.0.0.1 2346
