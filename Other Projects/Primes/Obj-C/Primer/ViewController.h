//
//  ViewController.h
//  Primer
//
//  Created by Nick Walker on 7/16/13.
//  Copyright (c) 2013 Nick Walker. All rights reserved.
//

#import <UIKit/UIKit.h>

@interface ViewController : UIViewController

@property IBOutlet UITextField* inputField;

@property IBOutlet UIActivityIndicatorView* spinner;
-(IBAction)valueChanged:(UITextField*)inputField;
@end
