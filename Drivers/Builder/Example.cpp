//---------------------------------------------------------------------------

#include <vcl.h>
#include <Sockets.hpp>
#include <Classes.hpp>
#include <iostream.h>

#include "Quanser.h"

//---------------------------------------------------------------------------

#pragma argsused
int main(int argc, char* argv[])
{
	Quanser* quanser = new Quanser("127.0.0.1",20072);

	for (int i = 0; i < 10; i++) {
		double _received = quanser->readAD(0);
		std::cout << "received: " << _received << "\n";
		int _result = quanser->writeDA(1,1.11);
		std::cout << "result: " << _result << "\n";
	}

	Sleep(4000);
	return 0;
}
//---------------------------------------------------------------------------
