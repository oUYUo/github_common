import java.awt.Graphics;
import java.util.ArrayList;

public class ChessPieces {
	public int number;
	public int state; // 3种状态，0表示无子，1表示白子，2表示黑子
	public ArrayList<Integer> changenb = new ArrayList<>();

	public ChessPieces(int number) {
		this.number = number;
	}

	public boolean canpressed(int state) {
		boolean flag = true;
		int count = 0;
		if (this.state == 0) {
			// 落子在上
			if (number < 56) {
				for (int i = 0; ((i < 8) && flag); i++) {
					if (ChessBoard.cps.get(number + 8).state != state && ChessBoard.cps.get(number + 8).state != 0) {
						if (i > 1) {
							if (ChessBoard.cps.get(number + i * 8).state == state) {
								for (int j = 1; j < i; j++) {
									if (ChessBoard.cps.get(number + j * 8).state != 0
											&& ChessBoard.cps.get(number + j * 8).state != state) {

										count++;
										if (count == i - 1) {
											return true;
										}
									}
								}
								count = 0;
							}
						}
						if ((number + i * 8) >= 56 && i != 0)
							flag = false;
					} else
						flag = false;
				}
				flag = true;
			}

			// 落子在下
			if (number > 7) {
				for (int i = 0; ((i < 8) && flag); i++) {
					if (ChessBoard.cps.get(number - 8).state != state && ChessBoard.cps.get(number - 8).state != 0) {
						if (i > 1) {
							if (ChessBoard.cps.get(number - i * 8).state == state) {
								for (int j = 1; j < i; j++) {
									if (ChessBoard.cps.get(number - j * 8).state != 0
											&& ChessBoard.cps.get(number - j * 8).state != state) {

										count++;
										if (count == i - 1) {
											return true;
										}
									}
								}
								count = 0;
							}
						}
						if ((number - i * 8) <= 7 && i != 0)
							flag = false;
					} else
						flag = false;
				}
				flag = true;
			}
			
			// 落子在右下
					if (number > 7 && number % 8 != 0) {
						for (int i = 0; ((i < 8) && flag); i++) {
							if (ChessBoard.cps.get(number - 9).state != state && ChessBoard.cps.get(number - 9).state != 0) {
								if (i > 1) {
									if (ChessBoard.cps.get(number - i * 9).state == state) {
										for (int j = 1; j < i; j++) {
											if (ChessBoard.cps.get(number - j * 9).state != 0
													&& ChessBoard.cps.get(number - j * 9).state != state) {

												count++;
												if (count == i - 1) {
													return true;
												}
											}
										}
										count = 0;
									}
								}
								if (((number - i * 9) <= 7 || (number - i * 9) % 8 == 0) && i != 0)
									flag = false;
							} else
								flag = false;
						}
					}
					flag = true;
					
				// 落子在左上
					if (number < 56 && number % 8 != 7) {
						for (int i = 0; ((i < 8) && flag); i++) {
							if (ChessBoard.cps.get(number + 9).state != state && ChessBoard.cps.get(number + 9).state != 0) {
								if (i > 1) {
									if (ChessBoard.cps.get(number + i * 9).state == state) {
										for (int j = 1; j < i; j++) {
											if (ChessBoard.cps.get(number + j * 9).state != 0
													&& ChessBoard.cps.get(number + j * 9).state != state) {

												count++;
												if (count == i - 1) {
													return true;
												}
											}
										}
										count = 0;
									}
								}
								if (((number + i * 9) >= 56 || (number + i * 9) % 8 == 7) && i != 0)
									flag = false;
							} else
								flag = false;
						}
					}
					flag = true;
					
					// 落子在左
					if (number % 8 != 7) {
						for (int i = 0; ((i < 8) && flag); i++) {
							if (ChessBoard.cps.get(number + 1).state != state && ChessBoard.cps.get(number + 1).state != 0) {
								if (i > 1) {
									if (ChessBoard.cps.get(number + i * 1).state == state) {
										for (int j = 1; j < i; j++) {
											if (ChessBoard.cps.get(number + j * 1).state != 0
													&& ChessBoard.cps.get(number + j * 1).state != state) {

												count++;
												if (count == i - 1) {
													return true;
												}
											}
										}
										count = 0;
									}
								}
								if ((number + i * 1) % 8 == 7 && i != 0)
									flag = false;
							} else
								flag = false;
						}
					}
					flag = true;
					
					// 落子在右
					if (number % 8 != 0) {
						for (int i = 0; ((i < 8) && flag); i++) {
							if (ChessBoard.cps.get(number - 1).state != state && ChessBoard.cps.get(number - 1).state != 0) {
								if (i > 1) {
									if (ChessBoard.cps.get(number - i * 1).state == state) {
										for (int j = 1; j < i; j++) {
											if (ChessBoard.cps.get(number - j * 1).state != 0
													&& ChessBoard.cps.get(number - j * 1).state != state) {

												count++;
												if (count == i - 1) {
													return true;
												}
											}
										}
										count = 0;
									}
								}
								if ((number - i * 1) % 8 == 0 && i != 0)
									flag = false;
							} else
								flag = false;
						}
					}
					flag = true;
					
					// 落子在右上
					if (number < 56 && number % 8 != 0) {
						for (int i = 0; ((i < 8) && flag); i++) {
							if (ChessBoard.cps.get(number + 7).state != state && ChessBoard.cps.get(number + 7).state != 0) {
								if (i > 1) {
									if (ChessBoard.cps.get(number + i * 7).state == state) {
										for (int j = 1; j < i; j++) {
											if (ChessBoard.cps.get(number + j * 7).state != 0
													&& ChessBoard.cps.get(number + j * 7).state != state) {

												count++;
												if (count == i - 1) {
													return true;
												}
											}
										}
										count = 0;
									}
								}
								if (((number + i * 7) >= 56 || (number + i * 7) % 8 == 0) && i != 0)
									flag = false;
							} else
								flag = false;
						}
					}
					flag = true;
					
					// 落子在左下
					if (number > 7 && number % 8 != 7) {
						for (int i = 0; ((i < 8) && flag); i++) {
							if (ChessBoard.cps.get(number - 7).state != state && ChessBoard.cps.get(number - 7).state != 0) {
								if (i > 1) {
									if (ChessBoard.cps.get(number - i * 7).state == state) {
										for (int j = 1; j < i; j++) {
											if (ChessBoard.cps.get(number - j * 7).state != 0
													&& ChessBoard.cps.get(number - j * 7).state != state) {

												count++;
												if (count == i - 1) {
													return true;
												}
											}
										}
										count = 0;
									}
								}
								if (((number - i * 7) <= 7 || (number - i * 7) % 8 == 7) && i != 0)
									flag = false;
							} else
								flag = false;
						}
					}
					flag = true;
				}

		return false;
	}
	
	
	
	public int pressed(int state) {
		boolean flag = true;
		int count = 0;
		if (this.state == 0) {
			// 落子在上
			if (number < 56) {
				for (int i = 0; ((i < 8) && flag); i++) {
					if (ChessBoard.cps.get(number + 8).state != state && ChessBoard.cps.get(number + 8).state != 0) {
						if (i > 1) {
							if (ChessBoard.cps.get(number + i * 8).state == state) {
								for (int j = 1; j < i; j++) {
									if (ChessBoard.cps.get(number + j * 8).state != 0
											&& ChessBoard.cps.get(number + j * 8).state != state) {

										count++;
										if (count == i - 1) {
											for (int j2 = 1; j2 < i; j2++) {
												changenb.add(number + j2 * 8);
											}
										}
									}
								}
								count = 0;
							}
						}
						if ((number + i * 8) >= 56 && i != 0)
							flag = false;
					} else
						flag = false;
				}
				flag = true;
			}

			// 落子在下
			if (number > 7) {
				for (int i = 0; ((i < 8) && flag); i++) {
					if (ChessBoard.cps.get(number - 8).state != state && ChessBoard.cps.get(number - 8).state != 0) {
						if (i > 1) {
							if (ChessBoard.cps.get(number - i * 8).state == state) {
								for (int j = 1; j < i; j++) {
									if (ChessBoard.cps.get(number - j * 8).state != 0
											&& ChessBoard.cps.get(number - j * 8).state != state) {

										count++;
										if (count == i - 1) {
											for (int j2 = 1; j2 < i; j2++) {
												changenb.add(number - j2 * 8);
											}
										}
									}
								}
								count = 0;
							}
						}
						if ((number - i * 8) <= 7 && i != 0)
							flag = false;
					} else
						flag = false;
				}
				flag = true;
			}
			
			// 落子在右下
					if (number > 7 && number % 8 != 0) {
						for (int i = 0; ((i < 8) && flag); i++) {
							if (ChessBoard.cps.get(number - 9).state != state && ChessBoard.cps.get(number - 9).state != 0) {
								if (i > 1) {
									if (ChessBoard.cps.get(number - i * 9).state == state) {
										for (int j = 1; j < i; j++) {
											if (ChessBoard.cps.get(number - j * 9).state != 0
													&& ChessBoard.cps.get(number - j * 9).state != state) {

												count++;
												if (count == i - 1) {
													for (int j2 = 1; j2 < i; j2++) {
														changenb.add(number - j2 * 9);
													}
												}
											}
										}
										count = 0;
									}
								}
								if (((number - i * 9) <= 7 || (number - i * 9) % 8 == 0) && i != 0)
									flag = false;
							} else
								flag = false;
						}
					}
					flag = true;
					
				// 落子在左上
					if (number < 56 && number % 8 != 7) {
						for (int i = 0; ((i < 8) && flag); i++) {
							if (ChessBoard.cps.get(number + 9).state != state && ChessBoard.cps.get(number + 9).state != 0) {
								if (i > 1) {
									if (ChessBoard.cps.get(number + i * 9).state == state) {
										for (int j = 1; j < i; j++) {
											if (ChessBoard.cps.get(number + j * 9).state != 0
													&& ChessBoard.cps.get(number + j * 9).state != state) {

												count++;
												if (count == i - 1) {
													for (int j2 = 1; j2 < i; j2++) {
														changenb.add(number + j2 * 9);
													}
												}
											}
										}
										count = 0;
									}
								}
								if (((number + i * 9) >= 56 || (number + i * 9) % 8 == 7) && i != 0)
									flag = false;
							} else
								flag = false;
						}
					}
					flag = true;
					
					// 落子在左
					if (number % 8 != 7) {
						for (int i = 0; ((i < 8) && flag); i++) {
							if (ChessBoard.cps.get(number + 1).state != state && ChessBoard.cps.get(number + 1).state != 0) {
								if (i > 1) {
									if (ChessBoard.cps.get(number + i * 1).state == state) {
										for (int j = 1; j < i; j++) {
											if (ChessBoard.cps.get(number + j * 1).state != 0
													&& ChessBoard.cps.get(number + j * 1).state != state) {

												count++;
												if (count == i - 1) {
													for (int j2 = 1; j2 < i; j2++) {
														changenb.add(number + j2 * 1);
													}
												}
											}
										}
										count = 0;
									}
								}
								if ((number + i * 1) % 8 == 7 && i != 0)
									flag = false;
							} else
								flag = false;
						}
					}
					flag = true;
					
					// 落子在右
					if (number % 8 != 0) {
						for (int i = 0; ((i < 8) && flag); i++) {
							if (ChessBoard.cps.get(number - 1).state != state && ChessBoard.cps.get(number - 1).state != 0) {
								if (i > 1) {
									if (ChessBoard.cps.get(number - i * 1).state == state) {
										for (int j = 1; j < i; j++) {
											if (ChessBoard.cps.get(number - j * 1).state != 0
													&& ChessBoard.cps.get(number - j * 1).state != state) {

												count++;
												if (count == i - 1) {
													for (int j2 = 1; j2 < i; j2++) {
														changenb.add(number - j2 * 1);
													}
												}
											}
										}
										count = 0;
									}
								}
								if ((number - i * 1) % 8 == 0 && i != 0)
									flag = false;
							} else
								flag = false;
						}
					}
					flag = true;
					
					// 落子在右上
					if (number < 56 && number % 8 != 0) {
						for (int i = 0; ((i < 8) && flag); i++) {
							if (ChessBoard.cps.get(number + 7).state != state && ChessBoard.cps.get(number + 7).state != 0) {
								if (i > 1) {
									if (ChessBoard.cps.get(number + i * 7).state == state) {
										for (int j = 1; j < i; j++) {
											if (ChessBoard.cps.get(number + j * 7).state != 0
													&& ChessBoard.cps.get(number + j * 7).state != state) {

												count++;
												if (count == i - 1) {
													for (int j2 = 1; j2 < i; j2++) {
														changenb.add(number + j2 * 7);
													}
												}
											}
										}
										count = 0;
									}
								}
								if (((number + i * 7) >= 56 || (number + i * 7) % 8 == 0) && i != 0)
									flag = false;
							} else
								flag = false;
						}
					}
					flag = true;
					
					// 落子在左下
					if (number > 7 && number % 8 != 7) {
						for (int i = 0; ((i < 8) && flag); i++) {
							if (ChessBoard.cps.get(number - 7).state != state && ChessBoard.cps.get(number - 7).state != 0) {
								if (i > 1) {
									if (ChessBoard.cps.get(number - i * 7).state == state) {
										for (int j = 1; j < i; j++) {
											if (ChessBoard.cps.get(number - j * 7).state != 0
													&& ChessBoard.cps.get(number - j * 7).state != state) {

												count++;
												if (count == i - 1) {
													for (int j2 = 1; j2 < i; j2++) {
														changenb.add(number - j2 * 7);
													}
												}
											}
										}
										count = 0;
									}
								}
								if (((number - i * 7) <= 7 || (number - i * 7) % 8 == 7) && i != 0)
									flag = false;
							} else
								flag = false;
						}
					}
					flag = true;
				}
			
		;
		
		int size = this.changenb.size();
		return size;
		
	}
	
	public void changeother(){
		for (int i = 0; i < this.changenb.size(); i++) {
			ChessBoard.cps.get(this.changenb.get(i)).state = this.state;
		}
	}
	
	public void clear(){
		for (int i = 0; i < this.changenb.size(); i++) {
			this.changenb.remove(i);
		}
	}
	/*
	 * int count = 0; int flag; //表示单前下的是白子还是黑子 if (state == 1) { flag = 2; }
	 * else { flag = 1; } for (int i = 0; i < 64; i++) { if ((i-number) % 8 == 0
	 * ) { if ((i-number) >= 8) { for(int j = 1; j < (i-number)/8; j++){
	 * if(ChessBoard.chessps[number+j*8].state == flag) count++; } if (count ==
	 * (i-number)/8 -1) { return true; } } if ((number-i) >= 8) { for(int j = 1;
	 * j < (i-number)/8; j++){ if(ChessBoard.chessps[number-j*8].state == flag)
	 * count++; } if (count == (number-i)/8 -1) { return true; } } } } }
	 */

	public boolean outRange(int number) {
		for (int i = 0; i < 8; i++) {
			if (number == i * 8 || number == i || number == (7 + i * 8) || number == (56 + i)) {
				return true;
			}
		}
		return false;
	}

	public void paint(Graphics g) {

		if (this.state != 0) {
			int x = this.number % 8;
			int y = this.number / 8;
			int testx = 48 * x + 72;
			int testy = 48 * y + 72;
			// testy = testy - (testy-17) % 48 + 7;
			// if((((testx-17) / 48 + (testy-17) / 48)%2) == 0){
			if ((x + y) % 2 == 0) {
				if (state == 1) {
					g.drawImage(GameFrame.imgs.get("00White"), testx, testy, null);
				} else {
					g.drawImage(GameFrame.imgs.get("00Black"), testx, testy, null);
				}
			} else {
				if (state == 1) {
					g.drawImage(GameFrame.imgs.get("01White"), testx, testy, null);
				} else {
					g.drawImage(GameFrame.imgs.get("01Black"), testx, testy, null);
				}
			}

		}

	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

}
