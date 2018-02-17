using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CreakingProblems1
{
    class Program
    {
        static void Main(string[] args)
        {
            string arreglo = "abcdefghijk";
            SearchCharacter(arreglo);
            SearchingDicctionary(arreglo);
            Console.ReadLine();
        }
        public static void SearchingDicctionary(string arreglo)
        {
            Dictionary<char, int> cadena = new Dictionary<char, int>();
            for (int i = 0; i < arreglo.Length; i++)
            {
                if(cadena.ContainsKey(arreglo[i]))
                {
                    Console.WriteLine("El arreglo tiene cáracteres repetidos");
                    return;
                }
                else
                {
                    cadena.Add(arreglo[i], 1);
                }
            }
            Console.WriteLine("El arreglo no tiene cáracteres repetidos.");
        }
        public static void SearchCharacter(string arreglo)
        {
            for(int i=0; i<arreglo.Length; i++)
            {
                for(int j=i+1; j<arreglo.Length; j++)
                {
                    if (arreglo[i] == arreglo[j])
                    {
                        Console.WriteLine("El arreglo tiene cáracteres repetidos.");
                        return;
                    }
                }
            }
            Console.WriteLine("El arreglo no tiene cáracteres repetidos.");

        }
    }
}
