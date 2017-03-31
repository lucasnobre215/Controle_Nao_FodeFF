//---------------------------------------------------------------------------

#ifndef QuanserH
#define QuanserH

#include <stdlib.h>
#include <cstdlib>
#include <stdio.h>
#include <iostream>
#include <string.h>
#include <sstream>
#include <Sockets.hpp>
#include <Classes.hpp>


//#include <sys/socket.h>
//#include <netinet/in.h>
//#include <arpa/inet.h>

using std::cout;
using std::cin;
using std::string;
using namespace std;

class Quanser {
private:
	TTcpClient* tcpClient;
	char*  server;
	int    tcpPort;

	/**
	 * Tenta conectar ao servidor, se conseguir conectar, retorna 0, se não
	 * conseguir, retorna 1
	 */
	int connectServer () {
		tcpClient->RemoteHost = (AnsiString) this->server;
		tcpClient->RemotePort = (AnsiString) itoa(this->tcpPort).c_str();
		if (tcpClient->Connect()) {
			return 0;
		}
		else {
			return 1;
		}
	}

	/**
	 *Converte de inteiro para std::string
	 */
	std::string itoa(int _toConvert){
		std::stringstream ss;
		std::string str;
		ss << _toConvert;
		ss >> str;
		return str;
	}
	/**
	 *Converte de float para std::string
	 */
	std::string ftoa(float _toConvert){
		std::stringstream ss;
		std::string str;
		ss << _toConvert;
		ss >> str;
		return str;
	}

	std::string receiveData() {
		std::string _received = "";
		_received = this->tcpClient->Receiveln("\n").c_str();
		return _received;
	}

	int sendData(std::string _toSend) {
		this->tcpClient->Sendln((AnsiString)_toSend.c_str(),"\n");
	}
///////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////

public:
   /**
	*Construtor
	*/
	Quanser (char* _server, int _tcpPort) {
		this->tcpClient = new TTcpClient(NULL);
		this->tcpPort = _tcpPort;
		this->server = _server;
		this->connectServer();
	}

	/**
	 *Grava a tensao especificada no parametro no canal DA
	 *Se o valor de retorno for diferente de 0, ocorreu erro.
	 */
	int writeDA(int _channel, float _volts) {
		std::string _toSend = "WRITE ";
		_toSend.append(itoa(_channel));
		_toSend.append(" ");
		_toSend.append(ftoa(_volts));
		_toSend.append("\n");
		this->sendData(_toSend);
		std::string _rec = this->receiveData();

		if (_rec.find("ACK",0) > _rec.length() )
			return -1 ; //erro
		else
			return 0;
   }


   /**
	*Le o valor de tensao que esta no canal AD especificado
	*/
	double readAD(int _channel) {
		std::string _toSend = "READ ";
		_toSend.append(itoa(_channel));
		_toSend.append("\n");
		this->sendData(_toSend);
		std::string _rec = this->receiveData();
		return atof(_rec.c_str());
	}


	/**
	 *Destrutor
	 */
	~Quanser(void){
		cout << "Destruido... \n";
		if (this->tcpClient->Connected) {
			this->tcpClient->Disconnect();
		}
   }
};


#endif	/* _QUANSER_H */



