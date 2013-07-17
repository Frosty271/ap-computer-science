//
//  prime.m
//  Primer
//
//  Created by Nick Walker on 7/17/13.
//  Copyright (c) 2013 Nick Walker. All rights reserved.
//

#import "Prime.h"

@implementation Prime

- (bool)testPrimeness:(int)candidate
{
	double cap = sqrt(candidate);
	if( fmod(cap, 1) == 0 ) return false;
	
	NSMutableArray* list = [[NSMutableArray alloc] initWithArray:(NSArray *)[self listPrimes:cap]];
	NSLog(@"%d", [list count]);
	NSLog(@"%@", list);
	for(int i = 0; i < [list count]; i++){
		if ( fmod(candidate, [[list objectAtIndex:i] doubleValue])  == 0 ){
			return false;
		}
	}
	return true;
}
- (NSMutableArray*) listPrimes:(double)cap	{
	NSMutableArray* primeList = [[NSMutableArray alloc] init];
	//Iterate over every number under our cap
	for (int i = 2; i < cap; i++) {
		
		//Check if x, starting at two, is a factor of i. repeat until x is i.
		for(int x=2; x <= i; x++){
			//If we're done, we can add it to the prime array and break out. Advance to the next integer under the cap
			if (x == i || x == i-1 )	{
				[primeList addObject:(id)[NSNumber numberWithInt:(int)i] ];
				break;
			}
			if( i%x == 0 ){
				break;
			}
		}
		
	}
	return primeList;
}
@end
