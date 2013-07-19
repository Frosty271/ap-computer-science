//
//  prime.h
//  Primer
//
//  Created by Nick Walker on 7/17/13.
//  Copyright (c) 2013 Nick Walker. All rights reserved.
//

#import <Foundation/Foundation.h>

@interface Prime : NSObject{
}
-(NSMutableArray*)listPrimes: (double)cap;
-(bool)testPrimeness: (long long)candidate;
@end
