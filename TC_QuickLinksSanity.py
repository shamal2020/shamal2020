
# Library imports
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.common.keys import Keys
import time
# Our imports
from Login import Login, Logout
from Nav import Nav, navToSublink
from constants import constPaths # paths that should never change




    
# from builtins import True


# ---------------------------- #
# Settings - Change as needed #
# --------------------------- #
useBrowser = 'chrome' #edge, chrome
maxWindowOnLoad = True
closeBrowserWhenFinished = False
defaultWaitTime = 10 # seconds - time default wait before select fails
useEnv = 'portaluat'
env = {
  'fredmod'   :  'https://fredmod.eagle.org/portal/#/Login',
  'fredint'   :  'https://fredint.eagle.org/portal/#/Login',
  'portaluat' :  'https://portaluat.eagle.org/portal//#/Login'
}

# --------------------------------- #
# Settings - Change if you have to  #
# --------------------------------- #
if useBrowser == 'edge':
#     Add webdrivers as needed (edge / chrome / firefox)
    browser = webdriver.Edge('msedgedriver')
else:
    browser = webdriver.Chrome()
browser.get(env[useEnv])

if maxWindowOnLoad == True:
    browser.set_window_size(1440, 900)
    browser.maximize_window()

# time to try to find NEXT element before timeout
# should be used to you just need for next item to exist before you continue
def pause(time = defaultWaitTime):
    browser.implicitly_wait(time)
# force browser to pause before moving on
# should be used to you need to see what is happening
def fPause(time = defaultWaitTime):
    browser.implicitly_wait(time)
    cantGetItem = browser.find_elements_by_css_selector('.will-never-find-this-item')

# /\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\ #
# ------------------------------------------------------------------ #
# ===================== Tests / Commands below ===================== #
# ------------------------------------------------------------------ #
# \/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/ #

# login,Quick links open different window 
runTest = True
if runTest:
    #LOGIN
    Login(browser, pause, 'Fortunato', 'abc12345')
    print('LOGIN SUCCESSFUL')
    fPause(1)
    
    # NAVIGATE TO HOME PAGE
    Nav(browser, By, pause, "Home")
    print('LANDED ON HOME PAGE SUCCESSFUL')
    pause(30)
    
    # REFRESH THE PAGE TO CLOSE THE SMART SCHEDULAR POP UP WINDOW
    browser.refresh()
    fPause(7)
    
    # NAVIGATE TO QUICK LINKS
    Nav(browser, By, pause, "Quick Links")
    fPause()
    print('Quick Links page opens')
    
    
    #TAKING SS
    browser.switch_to.window(window_name=browser.window_handles[-1])
    ms = int(round(time.time() * 1000)) # creates unique timestamp : import time
    browser.save_screenshot("screenshots/screenshot_" + str(ms) + ".png") # saves image with unique name
    fPause(2)
    print('SANITY PASS:Taking SS')
    
    # NAVIGATE TO PORT LOCATOR 
    navToSublink(browser, pause, By, 'Quick Links','Port Locator')
    fPause()
    print('Port locator page opens')
    
    #TAKING SS
    browser.switch_to.window(window_name=browser.window_handles[-1])
    ms = int(round(time.time() * 1000)) # creates unique timestamp : import time
    browser.save_screenshot("screenshots/screenshot_" + str(ms) + ".png") # saves image with unique name
    fPause(2)
    print('SANITY PASS:Taking SS')
    
    # NAVIGATE TO ABS RECORD
    navToSublink(browser, pause, By, 'Quick Links','ABS Record')
    fPause()
    print('ABS Record page opens')
    
    #TAKING SS
    browser.switch_to.window(window_name=browser.window_handles[-1])
    ms = int(round(time.time() * 1000)) # creates unique timestamp : import time
    browser.save_screenshot("screenshots/screenshot_" + str(ms) + ".png") # saves image with unique name
    fPause(2)
    print('SANITY PASS:Taking SS')
    
    # NAVIGATE TO RECOGNIZED SPECIALIST 
    navToSublink(browser, pause, By, 'Quick Links','Recognized Specialist')
    fPause()
    print('Recognized Specialist page opens')
    
    #TAKING SS
    browser.switch_to.window(window_name=browser.window_handles[-1])
    ms = int(round(time.time() * 1000)) # creates unique timestamp : import time
    browser.save_screenshot("screenshots/screenshot_" + str(ms) + ".png") # saves image with unique name
    fPause(2)
    print('SANITY PASS:Taking SS')
    
    # NAVIGATE TO TYPE APPROVAL
    navToSublink(browser, pause, By, 'Quick Links','Type Approval')
    fPause()
    print('Type Approval page opens')
    
    #TAKING SS
    browser.switch_to.window(window_name=browser.window_handles[-1])
    ms = int(round(time.time() * 1000)) # creates unique timestamp : import time
    browser.save_screenshot("screenshots/screenshot_" + str(ms) + ".png") # saves image with unique name
    fPause(2)
    print('SANITY PASS:Taking SS')
    # NAVIGATE TO APPROVAL MANUFACTURERS
    navToSublink(browser, pause, By, 'Quick Links','Approval Manufacturers')
    fPause()
    print('Approval Manufacturers page opens')
    
    # NAVIGATE TO OTHER PRODUCTS & SERVICES
    navToSublink(browser, pause, By, 'Quick Links','Other Products & Services')
    fPause()
    print('Other Products & Services page opens')
    
    #TAKING SS
    browser.switch_to.window(window_name=browser.window_handles[-1])
    ms = int(round(time.time() * 1000)) # creates unique timestamp : import time
    browser.save_screenshot("screenshots/screenshot_" + str(ms) + ".png") # saves image with unique name
    fPause(2)
    print('SANITY PASS:Taking SS')
    
    # NAVIGATE TO ENGINEERING SOFTWARE
    navToSublink(browser, pause, By, 'Quick Links','Engineering Software')
    fPause()
    print('Engineering Software page opens')
    
    #TAKING SS
    browser.switch_to.window(window_name=browser.window_handles[-1])
    ms = int(round(time.time() * 1000)) # creates unique timestamp : import time
    browser.save_screenshot("screenshots/screenshot_" + str(ms) + ".png") # saves image with unique name
    fPause(2)
    print('SANITY PASS:Taking SS')
    
    # NAVIGATE TO ENVIRONMENTAL COMPLIANCE
    navToSublink(browser, pause, By, 'Quick Links','Environmental Compliance')
    fPause()
    print('Environmental Compliance page opens')
    
    #TAKING SS
    browser.switch_to.window(window_name=browser.window_handles[-1])
    ms = int(round(time.time() * 1000)) # creates unique timestamp : import time
    browser.save_screenshot("screenshots/screenshot_" + str(ms) + ".png") # saves image with unique name
    fPause(2)
    print('SANITY PASS:Taking SS')
    
    #LOGOUT
    Logout(browser, pause)
    print('SIT PASS:Quick Links Sanity Test Successful')