using System;
using System.Numerics;
class SubarrayMean
{
    private long[] calculatePrefixSum(int[] arrayElements, int[] numberOfElementsAndQueries)
    {
        long[] prefixSum = new long[numberOfElementsAndQueries[0] + 1];
        prefixSum[0] = 0;
        for (int element = 1; element <= numberOfElementsAndQueries[0]; element++)
        {
            prefixSum[element] = prefixSum[element - 1] + arrayElements[element - 1];
        }
        return prefixSum;
    }
    
    static void Main(string[] args)
    {
        var numberOfElementsAndQueries = Array.ConvertAll(Console.ReadLine().Split(' '), int.Parse);
        var arrayElements = Array.ConvertAll(Console.ReadLine().Split(' '), long.Parse);

        long[] prefixSum = calculatePrefixSum(arrayElements, numberOfElementsAndQueries);

        for (var x = 0; x < numberOfElementsAndQueries[1]; x++)
        {
            var range = Array.ConvertAll(Console.ReadLine().Split(' '), int.
            Console.WriteLine((long)((long)(prefixSum[range[1]] - prefixSum[range[0] - 1]) / (range[1] - range[0] + 1)));
        }
    }
}