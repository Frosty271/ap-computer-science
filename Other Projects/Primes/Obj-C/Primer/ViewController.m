//
//  ViewController.m
//  Primer
//
//  Created by Nick Walker on 7/16/13.
//  Copyright (c) 2013 Nick Walker. All rights reserved.
//

#import "ViewController.h"
#import "math.h"
#import "Prime.h"
@interface ViewController ()

@end

@implementation ViewController

- (void)viewDidLoad
{
    [super viewDidLoad];
	
}
- (IBAction)valueChanged:(UITextView*)inputField	{
	id primeTester = [[Prime alloc] init];
	if(	[primeTester testPrimeness:(int)[[inputField text] intValue]])
	{
		inputField.layer.backgroundColor = [[UIColor greenColor] CGColor];
	}
	else{
		inputField.layer.backgroundColor = [[UIColor redColor] CGColor];
	}
}
- (void)didReceiveMemoryWarning
{
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}


@end
